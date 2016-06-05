package ru.itis.inform.lists;

public class LinkedList<T> implements List<T> {

    private int count;
    private Node<T> first;
    private Node<T> last;

    public LinkedList() {
        this.first = null;
        this.last = null;
    }
    public int getLength() {
        return this.count;
    }
    public Node<T> getFirst() {
        return this.first;
    }
    @Override
    public void add(T element) {
            Node<T> newNode = new Node<T>(element);

            if (first == null) {
                this.first = newNode;
                this.last = newNode;
            } else {
                this.last.setNext(newNode);
                newNode.setPrevious(this.last);
                this.last = newNode;
            }
            this.count++;

    }

    @Override
    public void remove(T element) {
        Node<T> node = this.first;
        if (node.getValue().equals(element)) {
            Node<T> next = first.getNext();
            next.setPrevious(null);
            this.first = first.getNext();
            this.count--;
            return;
        }

        for(int i = 0; i < count - 1; i++) {
            if(node.getNext().getValue().equals(element)) {
                if (i == count - 2) {
                    Node<T> next = null;
                    node.setNext(null);
                    count--;
                    return;
                } else {
                    Node<T> next = node.getNext().getNext();
                    node.setNext(next);
                    next.setPrevious(node);
                    count--;
                    return;
                }
            }
            node = node.getNext();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(this.first);
    }
    @Override
    public boolean equals (Object another) {
        if (another == null) return false;
        System.out.println("NULL");
        if (another == this) return true;
        System.out.println("not this");
        if (!(another instanceof LinkedList)) return false;

        System.out.println("LinkedList");
        LinkedList anotherList = (LinkedList) another;

        if (this.count != anotherList.getLength()) return false;

        System.out.println("right length");
        Node thisNode = first;
        Node anotherNode = (Node) anotherList.getFirst();

        while(anotherNode != null) {
            System.out.println("FirstNode: " + thisNode.getValue());
            System.out.println("AnotherNode: " + thisNode.getValue());
            if (!(thisNode.equals(anotherNode))) return false;
            thisNode = thisNode.getNext();
            anotherNode = anotherNode.getNext();
        }
        return true;
    }
}
