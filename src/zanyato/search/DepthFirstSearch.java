package zanyato.search;

import zanyato.graph.UndirectedGraph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {
    private boolean[] marked;
    private int[] edgeToVertex;
    private int source;

    public DepthFirstSearch(UndirectedGraph graph, int source) {
        marked = new boolean[graph.vertices()];
        edgeToVertex = new int[graph.vertices()];
        this.source = source;
        dfs(graph, source);
    }

    private void dfs(UndirectedGraph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                edgeToVertex[w] = v;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> getPathTo(int v) {
        if (!hasPathTo(v)) return null;
        List<Integer> path = new LinkedList<Integer>();
        for (int w = v; w != source; w = edgeToVertex[w]) {
            path.add(w);
        }
        path.add(source);
        Collections.reverse(path);
        return path;
    }
}
