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

    ///////////////////////////////// code challenge 36/////////////////////
    public Set<String> breadthTraverse(String root) {
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(root);
        visited.add(root);
        while (!queue.isEmpty()) {
            String vertex = queue.poll();
            for (Vertex v : getNeighbors(vertex)) {
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
            }
        }
        return visited;
    }
    /////////////////////////////////////code challenge 37///////////////////////

    public void addEdgeWithWeight(String data1, String data2, int weight) {
        Vertex Vertex1 = new Vertex(data1, weight);
        Vertex Vertex2 = new Vertex(data2, weight);


        adjVertices.get(Vertex1).add(Vertex2);
        adjVertices.get(Vertex2).add(Vertex1);
    }

    public String businessTrip(Graph graph, List<String> citiesNames) {
        int cost = 0;
        if (citiesNames.size() <= 1)
            return "null";

        int findWeight;
        for (int i = 0; i < citiesNames.size() - 1; i++) {
            findWeight = findWeight(graph, citiesNames.get(i), citiesNames.get(i + 1));

            if (findWeight == 0)
                return "False, $0";

            cost += findWeight;
        }
        return "True, $" + cost;
    }

    private int findWeight(Graph graph, String city1, String city2) {
        for (Vertex vertex : graph.getNeighbors(city1)) {
            if (Objects.equals(city2, vertex.label)) {
                return vertex.weight;
            }
        }
        return 0;
    }


     public Set<String> depthFirst(String root) {
        Set<String> visited = new LinkedHashSet<>();
        Stack<String> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);

                for (Vertex v : getNeighbors(vertex)) {
                    stack.push( v.label);
                }
            }
        }
        return visited;
    }

    public  String adjacencyListRepresentation(int[][] matrix) {
        if (matrix.length == 0)
            return "The matrix is empty";
        List<List<String>> adjacencyList = new ArrayList<>(matrix[0].length);
        char letter;
        //It will create indexes for the vertices
        for (int i : matrix[0]) {
            adjacencyList.add(new ArrayList<>(i));
        }
        System.out.println(adjacencyList);


        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                //if it is edge
                if (matrix[i][j] == 1) {
                    letter = (char) ((int) 'a' + j);
                    adjacencyList.get(i).add(String.valueOf(letter));
                }

            }
        }
        System.out.println(adjacencyList);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < adjacencyList.size(); i++) {
            letter = (char) ((int) 'a' + i);
            stringBuilder.append(letter).append("|");
            for (String edge : adjacencyList.get(i)) {
                stringBuilder.append(" -> ").append(edge);

            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


    boolean isExist(String A, String B, Graph graph){

        Set<String> visited = new LinkedHashSet();
        Queue<String> queue = new LinkedList();
        queue.add(A);
        visited.add(A);

        while(!queue.isEmpty()  ) {
            String vertex = (String)queue.poll();
            Iterator var6 = graph.getAdjVertices(vertex).iterator();

            while(var6.hasNext()) {
                Vertex v = (Vertex)var6.next();
                if (!visited.contains(v.label)) {
                    visited.add(v.label);
                    queue.add(v.label);
                }
                if (visited.contains(B)){
                    return true;
                }
            }
        }

        return false;

    }

    private List<Vertex> getAdjVertices(String data) {
        return (List)this.adjVertices.get(new Vertex(data));
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
