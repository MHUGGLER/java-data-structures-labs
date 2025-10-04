import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements Iterable<E> {

    public interface Position<E> {
        E getElement();
    }

    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrev() { return prev; }
        public Node<E> getNext() { return next; }
        public void setPrev(Node<E> p) { prev = p; }
        public void setNext(Node<E> n) { next = n; }
        public void setElement(E e) { element = e; }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    private Node<E> validate(Position<E> p) {
        return (Node<E>) p;
    }

    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer) return null;
        return node;
    }

    public Position<E> first() { return position(header.getNext()); }
    public Position<E> last() { return position(trailer.getPrev()); }
    public Position<E> before(Position<E> p) { return position(validate(p).getPrev()); }
    public Position<E> after(Position<E> p) { return position(validate(p).getNext()); }

    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

    public Position<E> addFirst(E e) { return addBetween(e, header, header.getNext()); }
    public Position<E> addLast(E e) { return addBetween(e, trailer.getPrev(), trailer); }
    public Position<E> addBefore(Position<E> p, E e) { return addBetween(e, validate(p).getPrev(), validate(p)); }
    public Position<E> addAfter(Position<E> p, E e) { return addBetween(e, validate(p), validate(p).getNext()); }
    public E set(Position<E> p, E e) {
        Node<E> node = validate(p);
        E old = node.getElement();
        node.setElement(e);
        return old;
    }
    public E remove(Position<E> p) {
        Node<E> node = validate(p);
        Node<E> pred = node.getPrev();
        Node<E> succ = node.getNext();
        pred.setNext(succ);
        succ.setPrev(pred);
        size--;
        E elem = node.getElement();
        node.setPrev(null);
        node.setNext(null);
        node.setElement(null);
        return elem;
    }

    private class ElementIterator implements Iterator<E> {
        private Position<E> cursor = first();
        public boolean hasNext() { return cursor != null; }
        public E next() {
            E elem = cursor.getElement();
            cursor = after(cursor);
            return elem;
        }
    }

    public Iterator<E> iterator() { return new ElementIterator(); }
}
