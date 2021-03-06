/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

 class GraphTest {

    Graph graph = new Graph();

    @Test
    public void testBasics() {
        // Node can be successfully added to the graph
        graph.addNode("Bob");
        graph.addNode("Alice");
        graph.addNode("Mary");
        graph.addNode("Noor");
        // The proper size is returned, representing the number of nodes in the graph
        assertEquals(4, graph.size());
        assertEquals("Vertex{label='Bob'}[]Vertex{label='Noor'}[]Vertex{label='Alice'}[]Vertex{label='Mary'}[]",
                graph.printGraph());
        //    All appropriate neighbors can be retrieved from the graph
        assertEquals("[]", graph.getNeighbors("Noor").toString());


        //An edge can be successfully added to the graph
        graph.addEdge("Bob", "Mary");
        graph.addEdge("Bob", "Alice");
        graph.addEdge("Alice", "Bob");
        graph.addEdge("Alice", "Noor");
        assertEquals(
                "Vertex{label='Bob'}[Vertex{label='Mary'}, Vertex{label='Alice'}, Vertex{label='Alice'}]Vertex{label='Noor'}[Vertex{label='Alice'}]Vertex{label='Alice'}[Vertex{label='Bob'}, Vertex{label='Bob'}, Vertex{label='Noor'}]Vertex{label='Mary'}[Vertex{label='Bob'}]",
                graph.printGraph());
        // All appropriate neighbors can be retrieved from the graph
        assertEquals("[Vertex{label='Alice'}]", graph.getNeighbors("Noor").toString());

        // A collection of all nodes can be properly retrieved from the graph
        assertEquals("[Vertex{label='Bob'}, Vertex{label='Noor'}, Vertex{label='Alice'}, Vertex{label='Mary'}]",
                graph.getNodes().toString());

    }

    //    A graph with only one node and edge can be properly returned
    @Test
    public void testOneNodeOneEdge() {
        graph.addNode("Noor");
        assertEquals(1, graph.size());
        assertEquals("Vertex{label='Noor'}[]",
                graph.printGraph());
        assertEquals("[]", graph.getNeighbors("Noor").toString());
        graph.addNode("Alice");

        graph.addEdge("Alice", "Noor");
        assertEquals(
                "Vertex{label='Noor'}[Vertex{label='Alice'}]Vertex{label='Alice'}[Vertex{label='Noor'}]",
                graph.printGraph());
        assertEquals("[Vertex{label='Alice'}]", graph.getNeighbors("Noor").toString());
        assertEquals("[Vertex{label='Noor'}, Vertex{label='Alice'}]",
                graph.getNodes().toString());
    }
     @Test
     public void breadthFirst(){

         Graph graph = new Graph();

         graph.addNode("Pandora");
         graph.addNode("Arendelle");
         graph.addNode("Metroville");
         graph.addNode("Monstroplolis");
         graph.addNode("Narnia");
         graph.addNode("Naboo");

         graph.addEdge("Pandora", "Arendelle");
         graph.addEdge("Arendelle", "Metroville");
         graph.addEdge("Arendelle", "Monstroplolis");
         graph.addEdge("Metroville", "Narnia");
         graph.addEdge("Metroville", "Naboo");
         graph.addEdge("Metroville", "Monstroplolis");
         graph.addEdge("Monstroplolis", "Naboo");
         graph.addEdge("Narnia", "Naboo");

         assertEquals("[Pandora, Arendelle, Metroville, Monstroplolis, Narnia, Naboo]", graph.breadthTraverse("Pandora").toString());
     }

     @Test
     public void breadthFirstOneVertex(){

         Graph graph = new Graph();

         graph.addNode("Pandora");
         assertEquals("[Pandora]", graph.breadthTraverse("Pandora").toString());
     }

     @Test
     public void breadthFirstTest(){

         Graph graph = new Graph();

         graph.addNode("Pandora");
         graph.addNode("Arendelle");
         graph.addNode("Metroville");

         graph.addEdge("Pandora", "Arendelle");

         assertEquals("[Pandora, Arendelle]", graph.breadthTraverse("Pandora").toString());
     }

     @Test
     public void testEmpty() {

         Graph graph = new Graph();
         List<String> path = new ArrayList<>();

         assertEquals("null", graph.businessTrip(graph, path));
     }

     @Test
     public void testOnlyListItem() {

         Graph graph = new Graph();
         List<String> path = new ArrayList<>();

         graph.addNode("Pandora");
         graph.addNode("Arendelle");
         graph.addNode("Metroville");
         graph.addNode("Monstroplolis");
         graph.addNode("Narnia");
         graph.addNode("Naboo");

         graph.addEdgeWithWeight("Pandora", "Arendelle", 150);
         graph.addEdgeWithWeight("Pandora", "Metroville", 82);


         graph.addEdgeWithWeight("Arendelle", "Metroville", 99);
         graph.addEdgeWithWeight("Arendelle", "Monstroplolis", 42);

         graph.addEdgeWithWeight("Metroville", "Monstroplolis", 105);
         graph.addEdgeWithWeight("Metroville", "Narnia", 37);
         graph.addEdgeWithWeight("Metroville", "Naboo", 26);

         graph.addEdgeWithWeight("Monstroplolis", "Naboo", 73);
         graph.addEdgeWithWeight("Narnia", "Naboo", 250);

         path.add("Metroville");

         assertEquals("null", graph.businessTrip(graph, path));

     }

     @Test
     public void testDifferentPaths() {

         Graph graph = new Graph();
         List<String> path = new ArrayList<>();

         graph.addNode("Pandora");
         graph.addNode("Arendelle");
         graph.addNode("Metroville");
         graph.addNode("Monstroplolis");
         graph.addNode("Narnia");
         graph.addNode("Naboo");

         graph.addEdgeWithWeight("Pandora", "Arendelle", 150);
         graph.addEdgeWithWeight("Pandora", "Metroville", 82);


         graph.addEdgeWithWeight("Arendelle", "Metroville", 99);
         graph.addEdgeWithWeight("Arendelle", "Monstroplolis", 42);

         graph.addEdgeWithWeight("Metroville", "Monstroplolis", 105);
         graph.addEdgeWithWeight("Metroville", "Narnia", 37);
         graph.addEdgeWithWeight("Metroville", "Naboo", 26);

         graph.addEdgeWithWeight("Monstroplolis", "Naboo", 73);
         graph.addEdgeWithWeight("Narnia", "Naboo", 250);

         path.add("Metroville");
         path.add("Pandora");

         assertEquals("True, $82", graph.businessTrip(graph, path));

         List<String> path1 = new ArrayList<>();
         path1.add("Arendelle");
         path1.add("Monstroplolis");
         path1.add("Naboo");

         assertEquals("True, $115", graph.businessTrip(graph, path1));

         List<String> path2 = new ArrayList<>();
         path2.add("Naboo");
         path2.add("Pandora");

         assertEquals("False, $0", graph.businessTrip(graph, path2));

         List<String> path3 = new ArrayList<>();
         path3.add("Narnia");
         path3.add("Arendelle");
         path3.add("Naboo");

         assertEquals("False, $0", graph.businessTrip(graph, path3));
     }
     @Test
     public void depthFirstTest(){

         Graph graph3 = new Graph();

         graph3.addNode("A");
         graph3.addNode("B");
         graph3.addNode("C");
         graph3.addNode("D");
         graph3.addNode("E");
         graph3.addNode("F");
         graph3.addNode("G");
         graph3.addNode("H");

         graph3.addEdge("A", "D");
         graph3.addEdge("A", "B");
         graph3.addEdge("B", "D");
         graph3.addEdge("B", "C");
         graph3.addEdge("C", "G");
         graph3.addEdge("D", "F");
         graph3.addEdge("D", "H");
         graph3.addEdge("D", "E");
         graph3.addEdge("F", "H");

         assertEquals("[A, B, C, G, D, E, H, F]", graph3.depthFirst("A").toString());
     }

     @Test
     public void depthFirstOneVertex(){

         Graph graph3 = new Graph();

         graph3.addNode("A");

         assertEquals("[A]", graph3.depthFirst("A").toString());
     }

     //    THIS TEST FOR THREE VERTICES AND ONE OF THEM DID NOT CONNECT WITH THE OTHER TWO VERTICES

     @Test
     public void depthFirstTest2(){

         Graph graph3 = new Graph();

         graph3.addNode("A");
         graph3.addNode("B");
         graph3.addNode("C");

         graph3.addEdge("A", "B");

         assertEquals("[A, B]", graph3.depthFirst("A").toString());
     }
}