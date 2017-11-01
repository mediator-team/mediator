package org.fmgroup.mediator.core.scheduler;

class TopoGraphVertice<T> {
    public T element = null;

    public TopoGraphVertice(T element) {
        this.element = element;
    }

    public TopoGraphVertice() {}

    @Override
    public String toString() {
        if (element == null) return String.format("VirtualNode (%d)", this.hashCode());
        return element.toString();
    }
}
