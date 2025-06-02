package datastructures.lists;

import datastructures.interfaces.List;

import java.util.Arrays;

public class CustomArrayList<T> implements List<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public CustomArrayList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        return (T) elements[index];
    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        elements[index] = element;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(Object o) {
        if (o == null)
            throw new NullPointerException("The provided element is null and cannot be added to list.");
        if (size == elements.length)
            ensureCapacity();

        elements[size] = o;
        size++;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        if (isEmpty())
            throw new IllegalStateException("The list is empty and cannot be searched.");
        if (o == null)
            throw new NullPointerException("The provided element is null and cannot be searched in list.");

        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i]))
                return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (isEmpty())
            throw new IllegalStateException("The list is empty and cannot remove elements.");
        if (o == null)
            throw new NullPointerException("The provided element is null and cannot be removed from list.");

        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                for (int j = i; j < size - 1; j++)
                    elements[j] = elements[j + 1];
                size--;
                return true;
            }
        }
        return false;
    }
}