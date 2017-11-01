package org.fmgroup.mediator.semantics.basic;

import org.fmgroup.mediator.language.MediatorLangParser;
import org.fmgroup.mediator.language.Program;
import org.fmgroup.mediator.language.Automaton;
import org.fmgroup.mediator.language.ValidationException;
import org.fmgroup.mediator.semantics.raw.graph.Edge;
import org.fmgroup.mediator.semantics.raw.graph.Graph;
import org.fmgroup.mediator.semantics.raw.graph.Vertice;

import java.util.*;

public class GraphBasic implements Graph {

    private Automaton reference = null;
    private List<VerticeBasic> vertices = new ArrayList<>();

    public GraphBasic(Automaton a, Map<String, MediatorLangParser.TermContext> params) {
        assert a.getParent() instanceof Program;

        reference = a;

        // construct initial state
        VerticeBasic init = null;
        try {
            init = new VerticeBasic(EvaluationBasic.getInitEvaluation(a));
        } catch (ValidationException e) {
            e.printStackTrace();
        }

        // explore
        Queue<VerticeBasic> queue = new PriorityQueue<>();
        queue.offer(init);

        VerticeBasic v;
        while ((v = queue.poll()) != null) {
            vertices.add(v);
        }
    }

    @Override
    public List<Vertice> getVertices() {
        return null;
    }

    @Override
    public List<Edge> getEdges() {
        return null;
    }

    @Override
    public String toString() {
        String str = "[GraphBasic]";
        return str;
    }
}
