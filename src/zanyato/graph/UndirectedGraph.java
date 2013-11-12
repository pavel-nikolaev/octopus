package zanyato.graph;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class UndirectedGraph implements IGraph {
    private int vertices;
    private int edges;
    private Bag<Integer>[] adj;

    public UndirectedGraph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;
        init();
    }

    public UndirectedGraph(InputStream is) throws IllegalArgumentException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        try {
            this.vertices = Integer.valueOf(br.readLine());
            this.edges = Integer.valueOf(br.readLine());
            init();
            String line;
            while ((line = br.readLine())!= null) {

                String[] numbers = line.split("[ ]");
                int v = Integer.valueOf(numbers[0]);
                int w = Integer.valueOf(numbers[1]);
                addEdge(v, w);
            }
            br.close();
        } catch (Exception e){
            throw new IllegalArgumentException("Incorrect input data", e);
        }
    }

    private void init() {
        adj = (Bag<Integer>[]) new Bag[vertices];
        for (int v = 0; v < vertices; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public int vertices() {
        return vertices;
    }

    @Override
    public int edges() {
        return edges;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int v = 0; v < vertices; v++) {
            sb.append(v).append("->");
            for (int w : adj(v)) {
                sb.append(w).append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
