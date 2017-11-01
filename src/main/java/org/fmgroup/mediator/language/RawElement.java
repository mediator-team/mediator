package org.fmgroup.mediator.language;

import org.antlr.v4.runtime.ParserRuleContext;

public interface RawElement {

    RawElement fromContext(ParserRuleContext context) throws ValidationException;

    RawElement getParent();
    RawElement setParent(RawElement parent);

    RawElement clone(RawElement parent) throws ValidationException;
    RawElement validate() throws ValidationException;

    // ParserRuleContext getReference();
}
