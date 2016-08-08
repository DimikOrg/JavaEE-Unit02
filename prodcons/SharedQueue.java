import java.util.LinkedList;

/**
* <h1>JavaEE Online Course</h1>
* <h2>Multithreading</h2>
* <p>
* These classes represents the usage of multithreading 
* in Java as demonstrated on the Online Course
* conducted by Dimik Computing.
* Feel free to fork and try it on your own.
* </p>
*
* @author  Mushfekur Rahman (https://github.com/mushfek0001)
* @version 1.0
* @since   2016-07-01 
*/
public class SharedQueue<E> {

    private LinkedList<E> list;
    private int size;

    public SharedQueue() {
    }

    public SharedQueue(int size) {
        this.list = new LinkedList<>();
        this.size = size;
    }

    public void add(E e) {
        list.add(e);
    }

    public E remove() {
        return list.remove(0);
    }

    public boolean isFull() {
        return list.size() >= size;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }
}
