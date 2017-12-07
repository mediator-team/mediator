package org.fmgroup.mediator.plugins.simulator;

import org.fmgroup.mediator.language.ValidationException;

public interface Evaluation {
    Evaluation copy() throws ValidationException;
}
