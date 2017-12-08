grammar TermAndType;

/*  NOTE: it should be carefully noticed that precedence in antlr4
    is precedence of **rules** instead of precedence of operators. e.g.

    - '!' term tries to find a shortest suffix which is a term
*/

// TODO: struct
// TODO: map

terms: (term (',' term)*)?;

term:	'(' term ')'                                                # bracketTerm
    |   '(' term (',' term)+ ')'                                    # tupleTerm
    |   '[' terms ']'                                               # listTerm
    |   opr='-' term                                                # singleOprTerm
    |   opr='!' term                                                # singleOprTerm
    |   callee=type '(' args=terms ')'                              # callTerm
    |   container=term '[' key=term ']'                             # elementTerm
    |   structure=term '.' key=ID                                   # fieldTerm
    |   left=term opr='%'  right=term                               # binaryOprTerm
    |   left=term opr='*'  right=term                               # binaryOprTerm
    |   left=term opr='/'  right=term                               # binaryOprTerm
    |	left=term opr='+'  right=term                               # binaryOprTerm
    |   left=term opr='-'  right=term                               # binaryOprTerm
    |   left=term opr='<'  right=term                               # binaryOprTerm
    |   left=term opr='<=' right=term                               # binaryOprTerm
    |   left=term opr='>'  right=term                               # binaryOprTerm
    |   left=term opr='>=' right=term                               # binaryOprTerm
    |   left=term opr='==' right=term                               # binaryOprTerm
    |   left=term opr='!=' right=term                               # binaryOprTerm
    |   left=term opr='^'  right=term                               # binaryOprTerm
    |   left=term opr='^^'  right=term                              # binaryOprTerm
    |   left=term opr='&'  right=term                               # binaryOprTerm
    |   left=term opr='&&' right=term                               # binaryOprTerm
    |   left=term opr='|'  right=term                               # binaryOprTerm
    |   left=term opr='||' right=term                               # binaryOprTerm
    |   condition=term '?' ifTrue=term ':' ifFalse=term             # iteTerm
    |   value                                                       # valueTerm
    ;

value:
        INT                                                         # intValue
    |   REAL                                                        # doubleValue
    |   STRING                                                      # strValue
    |   BOOLEAN                                                     # boolValue
    |   scopedID '.' PORTVAR_SUFFIX                                 # portVarValue
    |   scopedID                                                    # idValue
    |   'null'                                                      # nullValue
    ;

type:   '(' type ')'                                                # bracketType
    |   '(' type (',' type)+ ')'                                    # tupleType
    |   'int'                                                       # intType
    |   'int' lbound=term '..' ubound=term                          # boundedIntType
    |   'char'                                                      # charType
    |   'double'                                                    # doubleType
    |   'bool'                                                      # boolType
    |   'enum' '{' ID (',' ID) * '}'                                # enumType
    |   'struct' '{' (ID ':' type ';') + '}'                        # structType
    |   type '[' capacity=term ? ']'                                # listType
    |   type 'init' term                                            # initType
    |   type '|' type                                               # unionType
    |   'type'                                                      # abstractType
    |   'NULL'                                                      # nullType
    |   scopedID                                                    # idType
    |   scopedID ('<' typeorvalue (',' typeorvalue )* '>')?         # templateType
;

typeorvalue: type | value ;

scopedID:
    (scopes+=ID '.')* identifier=ID
    ;

fragment DIGIT  : [0-9] ;
INT             : DIGIT+ ;
REAL            : (INT)? '.' DIGIT+ ;
fragment LETTER : [a-zA-Z];
STRING          : '"' .*? '"' ;
BOOLEAN         : 'true' | 'false' ;
PORTVAR_SUFFIX  : 'value' | 'reqRead' | 'reqWrite';
ID              : (LETTER | '_') (LETTER | DIGIT | '_') *;

IGNORE          : ('\t'|' '|'\n') -> skip;