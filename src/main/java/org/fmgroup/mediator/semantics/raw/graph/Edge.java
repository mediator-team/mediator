package org.fmgroup.mediator.semantics.raw.graph;

public interface Edge {
    Graph getOwner();
    Vertice getSource();
    Vertice getTarget();
}
