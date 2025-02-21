import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphAlgorithmsTest {

    public static void main(String[] args) {
        testBfs();
        testDfs();
    }

    /**
     * Test the BFS method with a simple graph.
     */
    private static void testBfs() {
        System.out.println("Testing BFS...");

        // Create vertices
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");
        Vertex<String> e = new Vertex<>("E");

        // Create edges
        Set<Edge<String>> edges = new HashSet<>(Arrays.asList(
                new Edge<>(a, b, 1),
                new Edge<>(a, c, 1),
                new Edge<>(b, d, 1),
                new Edge<>(c, d, 1),
                new Edge<>(d, e, 1)
        ));

        // Create graph
        Set<Vertex<String>> vertices = new HashSet<>(Arrays.asList(a, b, c, d, e));
        Graph<String> graph = new Graph<>(vertices, edges);

        // Perform BFS
        List<Vertex<String>> bfsResult = GraphAlgorithms.bfs(a, graph);
        System.out.println("BFS result: " + bfsResult);
        // Expected Output [A, B, C, D, E]
    }

    /**
     * Test the DFS method with a simple graph.
     */
    private static void testDfs() {
        System.out.println("Testing DFS...");

        // Create vertices
        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");
        Vertex<String> e = new Vertex<>("E");

        // Create edges
        Set<Edge<String>> edges = new HashSet<>(Arrays.asList(
                new Edge<>(a, b, 1),
                new Edge<>(a, c, 1),
                new Edge<>(b, d, 1),
                new Edge<>(c, d, 1),
                new Edge<>(d, e, 1)
        ));

        // Create graph
        Set<Vertex<String>> vertices = new HashSet<>(Arrays.asList(a, b, c, d, e));
        Graph<String> graph = new Graph<>(vertices, edges);

        // Perform DFS
        List<Vertex<String>> dfsResult = GraphAlgorithms.dfs(a, graph);
        System.out.println("DFS result: " + dfsResult);
        // Expected Output [A, B, D, E, C]
    }
}