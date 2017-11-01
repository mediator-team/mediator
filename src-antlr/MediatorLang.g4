grammar MediatorLang;

import TermAndType;

prog: (dependency | typedef | function | automaton | system )* ;

dependency:
    'import' (ID '.') * (ID | '*') ';';

typedef: 'typedef' type 'as' ID ';';

statement:
    (target=term '=')? expr=term ';'                    # assignmentStatement
    |   'sync' ID (',' ID)*   ';'                       # synchronizingStatement
    |   'return' term         ';'                       # returnStatement
    |   'if' '(' condition=term ')'
        (thenstmt=statement | '{' thenstmts=statements '}')
        ('else' (elsestmt=statement | '{' elsestmts=statements '}'))?       # iteStatement
;

statements:
    (statement)*
;

compTemplate: '<' param (',' param)* '>';
param: ID ':' type;

function
locals [ boolean isNative = false ]
:
    ('native' {$isNative = true; })? 'function' compTemplate? name=ID '(' funcInterface ')' (':' returnType=type)?
    (
        {!$isNative}?
        '{'
            (
                localVariableDef
                | statement
            ) *
        '}'
        |
        {$isNative}?
        ';'
    )
;

localVariableDef : ID (',' ID) * ':' type ';';

funcInterface: (funcArg (',' funcArg) *)? ;
funcArg: ID (',' ID) * ':' type ;

portsDecl:
    ID (',' ID)* ':' direction=('in' | 'out') type
    ;

compInterface:
    (portsDecl (',' portsDecl)* )?
    ;

variableSegment: 'variables' '{' localVariableDef * '}' ;
transitionSegment:
    'transitions' '{'
        (transition)*
    '}'
;

transition:
    term '->' ( '{' statements '}' | statement )     # transitionSingle
    |   'group' '{' transition * '}'                    # transitionGroup
    ;

automaton
:
    'automaton' compTemplate? name=ID '(' compInterface ')' '{'
        (variableSegment | transitionSegment )*
    '}'
;

componentSegment: 'components' '{' (componentDecl ';')* '}';
internalSegment: 'internals' ID (',' ID)* ';' ;
connectionSegment: 'connections' '{' (connectionDecl ';')* '}';

componentDecl: ID (',' ID)* ':' type;
connectionDecl:  type '(' term ')';

system
:
    'system' compTemplate? name=ID '(' compInterface ')' '{'
        (componentSegment | internalSegment | connectionSegment)*
    '}'
;

LINE_COMMENT  : '//' .*? '\r'? '\n' -> skip ; // Match"//" stuff '\n'
COMMENT       : '/*' .*? '*/' ->skip ;        // Match "/*" stuff "*/"
IGNORE          : ('\t'|' '|'\n') -> skip;