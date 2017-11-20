package org.fmgroup.mediator.language.entity;

import org.fmgroup.mediator.language.Template;
import org.fmgroup.mediator.language.RawElement;

public interface Entity extends RawElement {
    EntityInterface getInterface();
    Template getTemplate();
}
