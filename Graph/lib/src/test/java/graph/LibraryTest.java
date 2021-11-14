/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package graph;

import org.junit.jupiter.api.Test;

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

}