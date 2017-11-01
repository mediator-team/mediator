package org.fmgroup.mediator.semantics.basic;

import org.fmgroup.mediator.semantics.raw.graph.Vertice;

public class VerticeBasic implements Vertice {
    private EvaluationBasic ev;

    public VerticeBasic(EvaluationBasic ev) {
        assert ev != null;
        this.ev = ev;
    }

    public VerticeBasic() {
        this.ev = new EvaluationBasic();
    }

    public EvaluationBasic evaluation() { return this.ev; }

}
