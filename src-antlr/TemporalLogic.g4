grammar TemporalLogic;
import TermAndType;

pathFormulae:
    term                                                           # atomicPathFormulae
    | '!' pathFormulae                                             # notPathFormulae
    | 'A' stateFormulae                                            # allPathFormulae
    | 'E' stateFormulae                                            # existsPathFormulae
    | left=pathFormulae opr='->'  right=pathFormulae               # binaryPathFormulae
    | left=pathFormulae opr='<-'  right=pathFormulae               # binaryPathFormulae
    | left=pathFormulae opr='<->' right=pathFormulae               # binaryPathFormulae
    | left=pathFormulae opr='&&'  right=pathFormulae               # binaryPathFormulae
    | left=pathFormulae opr='||'  right=pathFormulae               # binaryPathFormulae
    | '(' pathFormulae ')'                                         # bracketPathFormulae
;

stateFormulae:
    pathFormulae                                                    # pathStateFormulae
    | '!' stateFormulae                                             # notStateFormulae
    | left=stateFormulae opr='->'  right=stateFormulae              # binaryStateFormulae
    | left=stateFormulae opr='<-'  right=stateFormulae              # binaryStateFormulae
    | left=stateFormulae opr='<->' right=stateFormulae              # binaryStateFormulae
    | left=stateFormulae opr='&&'  right=stateFormulae              # binaryStateFormulae
    | left=stateFormulae opr='||'  right=stateFormulae              # binaryStateFormulae
    | 'X' stateFormulae                                             # nextStateFormulae
    | 'F' stateFormulae                                             # finallyStateFormulae
    | 'G' stateFormulae                                             # globallyStateFormulae
    | '[' keep=stateFormulae 'U' until=stateFormulae ']'            # untilStateFormulae
    | '(' stateFormulae ')'                                         # bracketStateFormulae
;