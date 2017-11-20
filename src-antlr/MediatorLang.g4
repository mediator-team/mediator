grammar MediatorLang;

import TermAndType;

prog: (dependency | typedef | function | automaton | system )* ;

dependency:
    'import' (ID '.') * (ID | '*') ';';

typedef: 'typedef' type 'as' ID (',' ID)* ';';

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

entityTemplate: '<' localVariableDef (',' localVariableDef)* '>';

function
locals [ boolean isNative = false ]
:
    ('native' {$isNative = true; })? 'function' entityTemplate? name=ID '(' funcInterface ')' (':' returnType=type)?
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

funcInterface: (localVariableDef (',' localVariableDef) *)? ;

portsDecl:
    ID (',' ID)* ':' direction=('in' | 'out') type
    ;

compInterface:
    (portsDecl (',' portsDecl)* )?
    ;

variableSegment: 'variables' '{' (localVariableDef ';') * '}' ;
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
    'automaton' entityTemplate? name=ID '(' compInterface ')' '{'
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
    'system' entityTemplate? name=ID '(' compInterface ')' '{'
        (componentSegment | internalSegment | connectionSegment)*
    '}'
;

LINE_COMMENT  : '//' .*? '\r'? '\n' -> skip ; // Match"//" stuff '\n'
COMMENT       : '/*' .*? '*/' ->skip ;        // Match "/*" stuff "*/"
IGNORE          : ('\t'|' '|'\n') -> skip;