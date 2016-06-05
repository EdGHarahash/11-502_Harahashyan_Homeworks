package ru.itis.inform.lists;

public class LinkedListIterator<T> implements Iterator<T> {
    Node<T> current;
    @Override
    public boolean hasNext() {
        return current!= null;
    }

    @Override
    public void next() {
        this.current = current.getNext();
    }

    @Override
    public T peekNext() {
        return current.getValue();
    }

    @Override
    public Node getNext() {
        return current;
    }

    @Override
    public void previous() {
        if (current.getPrevious() != null) {
            current = current.getPrevious();
        } else {
            throw new NullPointerException();
        }

    }

    @Override
    public T peekPrevious() {
        if (current.getPrevious() != null) {
            return current.getPrevious().getValue();
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public void insert(T element) {
        Node<T> newNode = new Node<T>(element);

        newNode.setNext(current);
        newNode.setPrevious(current.getPrevious());

        current.getPrevious().setNext(newNode);
        current.setPrevious(newNode);

    }
    public LinkedListIterator(Node<T> first) {
        this.current = first;
    }
}
