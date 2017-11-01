package org.fmgroup.mediator.language.term;

import org.fmgroup.mediator.language.RawElement;
import org.fmgroup.mediator.language.type.Type;

public interface Term extends RawElement {
    Type getType();
    int getPrecedence();
}
