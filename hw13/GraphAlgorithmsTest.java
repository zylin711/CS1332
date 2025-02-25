import java.util.HashSet;
import java.util.Set;

public class GraphAlgorithmsTest {

    public static void main(String[] args) {
        testConnectedGraph();
        testDisconnectedGraph();
        testSingleVertexGraph();
        testGraphWithMultipleEdges();
    }

    /**
     * Test Prim's algorithm on a connected graph.
     */
    public static void testConnectedGraph() {
        System.out.println("Running testConnectedGraph...");

        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");
        Vertex<String> d = new Vertex<>("D");

        Set<Vertex<String>> vertices = new HashSet<>();
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);

        Set<Edge<String>> edges = new HashSet<>();
        edges.add(new Edge<>(a, b, 1));
        edges.add(new Edge<>(b, a, 1));
        edges.add(new Edge<>(a, c, 4));
        edges.add(new Edge<>(c, a, 4));
        edges.add(new Edge<>(b, c, 2));
        edges.add(new Edge<>(c, b, 2));
        edges.add(new Edge<>(b, d, 5));
        edges.add(new Edge<>(d, b, 5));
        edges.add(new Edge<>(c, d, 3));
        edges.add(new Edge<>(d, c, 3));

        Graph<String> graph = new Graph<>(vertices, edges);

        Set<Edge<String>> mst = GraphAlgorithms.prims(a, graph);

        if (mst != null) {
            System.out.println("MST Edges:");
            for (Edge<String> edge : mst) {
                System.out.println(edge);
            }
        } else {
            System.out.println("No MST exists (graph is disconnected).");
        }
    }

    /**
     * Test Prim's algorithm on a disconnected graph.
     */
    public static void testDisconnectedGraph() {
        System.out.println("\nRunning testDisconnectedGraph...");

        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");

        Set<Vertex<String>> vertices = new HashSet<>();
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);

        Set<Edge<String>> edges = new HashSet<>();
        edges.add(new Edge<>(a, b, 1));
        edges.add(new Edge<>(b, a, 1));

        Graph<String> graph = new Graph<>(vertices, edges);

        Set<Edge<String>> mst = GraphAlgorithms.prims(a, graph);

        if (mst != null) {
            System.out.println("MST Edges:");
            for (Edge<String> edge : mst) {
                System.out.println(edge);
            }
        } else {
            System.out.println("No MST exists (graph is disconnected).");
        }
    }

    /**
     * Test Prim's algorithm on a graph with a single vertex.
     */
    public static void testSingleVertexGraph() {
        System.out.println("\nRunning testSingleVertexGraph...");

        Vertex<String> a = new Vertex<>("A");

        Set<Vertex<String>> vertices = new HashSet<>();
        vertices.add(a);

        Set<Edge<String>> edges = new HashSet<>();

        Graph<String> graph = new Graph<>(vertices, edges);

        Set<Edge<String>> mst = GraphAlgorithms.prims(a, graph);

        if (mst != null) {
            System.out.println("MST Edges:");
            for (Edge<String> edge : mst) {
                System.out.println(edge);
            }
        } else {
            System.out.println("No MST exists (graph is disconnected).");
        }
    }

    /**
     * Test Prim's algorithm on a graph with multiple edges and loops.
     */
    public static void testGraphWithMultipleEdges() {
        System.out.println("\nRunning testGraphWithMultipleEdges...");

        Vertex<String> a = new Vertex<>("A");
        Vertex<String> b = new Vertex<>("B");
        Vertex<String> c = new Vertex<>("C");

        Set<Vertex<String>> vertices = new HashSet<>();
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);

        Set<Edge<String>> edges = new HashSet<>();
        edges.add(new Edge<>(a, b, 1));
        edges.add(new Edge<>(b, a, 1));
        edges.add(new Edge<>(a, c, 3));
        edges.add(new Edge<>(c, a, 3));
        edges.add(new Edge<>(b, c, 2));
        edges.add(new Edge<>(c, b, 2));
        edges.add(new Edge<>(a, a, 10));
        edges.add(new Edge<>(b, b, 8));

        Graph<String> graph = new Graph<>(vertices, edges);

        Set<Edge<String>> mst = GraphAlgorithms.prims(a, graph);

        if (mst != null) {
            System.out.println("MST Edges:");
            for (Edge<String> edge : mst) {
                System.out.println(edge);
            }
        } else {
            System.out.println("No MST exists (graph is disconnected).");
        }
    }
}