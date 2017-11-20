package org.fmgroup.mediator.language;

import org.fmgroup.mediator.language.scope.Scope;

public interface Templated extends RawElement, Scope {
    Template getTemplate();
}
