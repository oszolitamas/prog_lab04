package lab_04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class PQueue<T extends Comparable<T>> implements Iterable<T> {
	private ArrayList<T> elements = new ArrayList<>();

    public PQueue() {}

    public void push(T t) {
        elements.add(t);
    }

    public T pop() {
        if (elements.isEmpty()) {
            throw new EmptyQueueException("A sor ures!");
        }
        T max = Collections.max(elements);
        elements.remove(max);
        return max;
    }
    
    public T top() {
        if (elements.isEmpty()) {
            throw new EmptyQueueException("A sor ures!");
        }
        return Collections.max(elements);
    }

    public int size() {
        return elements.size();
    }

    public void clear() {
        elements.clear();
    }
    
    //10. feladat
    public Iterator<T> iterator() {
        ArrayList<T> copy = new ArrayList<>(elements);
        Collections.sort(copy, Collections.reverseOrder());
        return copy.iterator();
    }
}
