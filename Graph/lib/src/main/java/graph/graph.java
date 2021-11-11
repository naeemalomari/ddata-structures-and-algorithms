package graph;

import java.util.*;

class Graph {
    private final Map<Vertex, List<Vertex>> adjVertices;

    Graph() {
        adjVertices = new HashMap<>();
    }


    /**
     * To add vertex
     *
     * @param value
     * @return The added node
     */
    Vertex addNode(String value) {
        Vertex node = new Vertex(value);
        adjVertices.putIfAbsent(node, new ArrayList<>());
        return node;
    }

    /**
     * To add edge
     *
     * @param data1
     * @param data2
     */
    void addEdge(String data1, String data2) {
        Vertex vertex1 = new Vertex(data1);
        Vertex vertex2 = new Vertex(data2);

        adjVertices.get(vertex1).add(vertex2);
        adjVertices.get(vertex2).add(vertex1);
    }


    void removeVertex(String data) {
        Vertex vertex = new Vertex(data);
        adjVertices.values().forEach(list -> list.remove(vertex));
        adjVertices.remove(new Vertex(data));
    }

    void removeEdge(String data1, String data2) {
        Vertex vertex1 = new Vertex(data1);
        Vertex vertex2 = new Vertex(data2);

        List<Vertex> edgeVertex1 = adjVertices.get(vertex1);
        List<Vertex> edgeVertex2 = adjVertices.get(vertex2);

        if (edgeVertex1 != null) {
            edgeVertex1.remove(vertex2);
        }
        if (edgeVertex2 != null) {
            edgeVertex2.remove(vertex1);
        }
    }

    /**
     * @return all the nodes in the graph as a set collection
     */
    public java.util.Set<graph.Vertex> getNodes() {
        return adjVertices.keySet();
    }

    /**
     * @param data
     * @return Returns a collection of edges connected to the given node
     * Include the weight of the connection in the returned collection
     */
    List<Vertex> getNeighbors(String data) {
        Vertex vertex = new Vertex(data);
        return adjVertices.get(vertex);
    }


    String printGraph() {
        if (adjVertices.isEmpty()) {
            return null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (Vertex vertex : adjVertices.keySet()) {
                stringBuilder.append(vertex);
                stringBuilder.append(adjVertices.get(vertex));
            }
            return stringBuilder.toString();
        }
    }

    /**
     * @return the total number of nodes in the graph
     */
    int size() {
        return adjVertices.size();
    }
}
