grammar MediatorLang;

import TemporalLogic;

prog: (dependency | typedef | function | automaton | system )* ;

dependency
    locals [ boolean importAll = false ]
:
    'import' importedlib=scopedID ';'
    | 'from' fromlib=scopedID 'import' (ID (',' ID)* | '*' {$importAll = true;})';'
;

typedef: 'typedef' type 'as' ID (',' ID)* ';';

portIdentifier: (owner=ID '.')? identifier=ID;

statement:
    (target=term '=')? expr=term ';'                                        # assignmentStatement
    |   'sync' portIdentifier (',' portIdentifier)*   ';'                   # synchronizingStatement
    |   'return' term         ';'                                           # returnStatement
    |   'if' '(' condition=term ')'
        (thenstmt=statement | '{' thenstmts=statements '}')
        ('else' (elsestmt=statement | '{' elsestmts=statements '}'))?       # iteStatement
    |   'assert' term ';'                                                   # assertStatement
;

statements:
    (statement)*
;

template: '<' localVariableDef (',' localVariableDef)* '>';

function
locals [ boolean isNative = false ]
:
    ('native' {$isNative = true; })? 'function' template? name=ID '(' functionInterface ')' (':' returnType=type)?
    (
        {!$isNative}?
        '{'
            (
                'variables' '{' (localVariableDef ';')* '}'
                | 'statements' '{' statement* '}'
            ) *
        '}' meta?
        |
        {$isNative}?
        ';'
    )
;

localVariableDef : ID (',' ID) * ':' type;

functionInterface: (localVariableDef (',' localVariableDef) *)? ;

portsDecl:
    ID (',' ID)* ':' direction=('in' | 'out') type
    ;

entityInterface:
    (portsDecl (',' portsDecl)* )?
    ;

variableSegment: 'variables' '{' (localVariableDef ';') * '}' ;
transitionSegment:
    'transitions' '{'
        (transition)*
    '}'
;

transition:
    term '->' ( '{' statements '}' | statement )        # transitionSingle
    |   'group' '{' transition * '}'                    # transitionGroup
    ;

propertySegment:
    'properties' '{'
        (ID ':' property ';')*
    '}'
;

property: pathFormulae;

automaton
:
    'automaton' template? name=ID '(' entityInterface ')' '{'
        (variableSegment | transitionSegment | propertySegment)*
    '}'
    meta?
;

componentSegment: 'components' '{' (componentDecl ';')* '}';
internalSegment: 'internalCollection' ID (',' ID)* ';' ;
connectionSegment: 'connections' '{' (connectionDecl ';')* '}';

componentDecl: ID (',' ID)* ':' type;
connectionDecl:  type '(' portIdentifier (',' portIdentifier)* ')';

system
:
    'system' template? name=ID '(' entityInterface ')' '{'
        (componentSegment | internalSegment | connectionSegment)*
    '}'
    meta?
;

meta
:
    'meta' '{' (ID '=' term (',' ID '=' term)*)? '}'
;

LINE_COMMENT  : '//' .*? '\r'? '\n' -> skip ; // Match"//" stuff '\n'
COMMENT       : '/*' .*? '*/' ->skip ;        // Match "/*" stuff "*/"
IGNORE          : ('\t'|' '|'\n') -> skip;