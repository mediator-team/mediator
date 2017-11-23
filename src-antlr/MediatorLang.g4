grammar MediatorLang;

import TermAndType;

prog: (dependency | typedef | function | automaton | system )* ;

dependency:
    'import' (ID '.') * (ID | '*') ';';

typedef: 'typedef' type 'as' ID (',' ID)* ';';

portIdentifier: (owner=ID '.')? identifier=ID;

statement:
    (target=term '=')? expr=term ';'                                        # assignmentStatement
    |   'sync' portIdentifier (',' portIdentifier)*   ';'                   # synchronizingStatement
    |   'return' term         ';'                                           # returnStatement
    |   'if' '(' condition=term ')'
        (thenstmt=statement | '{' thenstmts=statements '}')
        ('else' (elsestmt=statement | '{' elsestmts=statements '}'))?       # iteStatement
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
        '}'
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

automaton
:
    'automaton' template? name=ID '(' entityInterface ')' '{'
        (variableSegment | transitionSegment )*
    '}'
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
;

LINE_COMMENT  : '//' .*? '\r'? '\n' -> skip ; // Match"//" stuff '\n'
COMMENT       : '/*' .*? '*/' ->skip ;        // Match "/*" stuff "*/"
IGNORE          : ('\t'|' '|'\n') -> skip;