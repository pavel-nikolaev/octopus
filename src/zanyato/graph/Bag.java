package zanyato.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Bag<T> implements Iterable<T> {
    private List<T> list = new LinkedList<T>();

    public Bag() {
        //do nothing
    }

    void add(T t) {
        list.add(t);
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }
}
