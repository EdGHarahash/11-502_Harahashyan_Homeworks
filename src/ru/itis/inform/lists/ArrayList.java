package ru.itis.inform.lists;

public class ArrayList<T> {
    private Object [] elements;
    private int size = 0;
    private int fillsize = 0;
    private final int defaultSize = 10;
    public ArrayList() {
        this.elements = new Object[defaultSize];
        this.size=defaultSize;
    }

    public ArrayList(int size) {
        this.elements = new Object[size];
        this.size=size;
    }

    public int size() {
        return this.fillsize;
    }

    private void ensureCapacity() {
        int newSize = size * 3 / 2;
        Object[] newArray = new Object[newSize];

        System.arraycopy(elements, 0, newArray, 0, size);

        this.elements = newArray;
        size = newSize;
    }

    public void add(T element) {
        if (fillsize == elements.length) {
            ensureCapacity();
        }
        elements[fillsize+1] = element;
        this.fillsize++;
    }
    public T get(int index) {
        if (index > elements.length|| index < 0)
            throw new IndexOutOfBoundsException();
        else return (T) elements[index];
    }
}
