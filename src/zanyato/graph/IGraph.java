package zanyato.graph;

public interface IGraph {
    void addEdge(int v, int w);
    Iterable<Integer> adj(int v);
    int vertices();
    int edges();
}
