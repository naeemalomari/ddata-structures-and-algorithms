package graph;

import java.util.Objects;

class Vertex {
    String label;
    int weight;

    public Vertex(String label) {
        this.label = label;
    }

    public Vertex(String label, int weight) {
        this.label = label;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public Vertex() {
        super();
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vertex)) return false;
        Vertex vertex = (Vertex) obj;
        return label.equals(vertex.label);
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                '}';
    }
}