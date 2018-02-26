package org.fmgroup.mediator.plugins.scheduler;

import java.util.*;

public class TopoGraph<Tvertice> {

    public Set<TopoGraphVertice> vertices = new HashSet<>();
    public Map<TopoGraphVertice, List<TopoGraphVertice>> edges = new HashMap<>();

    public TopoGraphVertice createNode(Tvertice value) {
        TopoGraphVertice newTopoGraphVertice = new TopoGraphVertice<Tvertice>(value);
        vertices.add(newTopoGraphVertice);
        return newTopoGraphVertice;
    }

    public TopoGraphVertice createVirtualNode () {
        TopoGraphVertice v = new TopoGraphVertice();
        vertices.add(v);
        return v;
    }

    public TopoGraphVertice getNode(Tvertice value) {
        for (TopoGraphVertice v : vertices) {
            if (v.element != null && v.element.equals(value)) return v;
        }

        return null;
    }

    public TopoGraphVertice getOrCreateNode(Tvertice value) {
        if (getNode(value) == null) return createNode(value);
        else return getNode(value);
    }

    public void connect(TopoGraphVertice from, TopoGraphVertice to) {
        if (!edges.containsKey(from)) {
            edges.put(from, new ArrayList<>());
        }

        edges.get(from).add(to);
    }

    public int countInEdges(TopoGraphVertice v) {
        int count = 0;
        for (TopoGraphVertice from : this.edges.keySet()) {
            if (this.edges.get(from).contains(v)) count ++;
        }

        return count;
    }

    public int countOutEdges (TopoGraphVertice v) {
        if (!edges.containsKey(v)) return 0;
        else
            return edges.get(v).size();
    }

    public List<Tvertice> TopologySort() {

        Map<TopoGraphVertice, Integer> inCount = new HashMap<>();
        for (TopoGraphVertice v : this.vertices) {
            inCount.put(v, countInEdges(v));
        }

        List<Tvertice> result = new ArrayList<>();

        while (this.vertices.size() > 0) {
            boolean allocated = false;

            for (TopoGraphVertice<Tvertice> vt : inCount.keySet()) {
                if (inCount.get(vt) == 0) {
                    // available now !!
                    this.vertices.remove(vt);
                    inCount.remove(vt);
                    if (edges.containsKey(vt)) {
                        for (TopoGraphVertice next : edges.get(vt)) {
                            inCount.put(next, inCount.get(next) - 1);
                        }
                        edges.remove(vt);
                    }

                    if (vt.element != null) result.add(vt.element);

                    allocated = true;
                    break;
                }
            }

            if (!allocated) {
                // fail to schedule the statements
                return null;
            }
        }

        return result;
    }

}
