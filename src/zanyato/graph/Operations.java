package zanyato.graph;

public class Operations {
    public static int degree(UndirectedGraph graph, int v) {
        int degree = 0;
        for (int w : graph.adj(v)) degree++;
        return degree;
    }

    public static int maxDegree(UndirectedGraph graph) {
        int maxDegree = 0;
        for (int v = 0; v < graph.vertices(); v++) {
            int degree = degree(graph, v);
            maxDegree = degree > maxDegree ? degree : maxDegree;
        }
        return maxDegree;
    }

    public static double averageDegree(UndirectedGraph graph) {
        return 2.0*graph.edges()/graph.vertices();
    }

    public static int numberOfSelfLoops(UndirectedGraph graph) {
        int count = 0;
        for (int v = 0; v < graph.vertices(); v++) {
            for (int w : graph.adj(v))
                if (v == w) count++;
        }
        return count/2;
    }
}
