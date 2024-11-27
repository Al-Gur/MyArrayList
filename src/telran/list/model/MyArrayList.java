package telran.list.model;

import telran.list.interfaces.IList;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> implements IList<E> {
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    private Object[] elements;
    private int size;

    public MyArrayList() {
        elements = new Object[10];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal capacity = " + initialCapacity);
        }
        if (initialCapacity > MAX_ARRAY_SIZE) {
            initialCapacity = MAX_ARRAY_SIZE;
        }
        elements = new Object[initialCapacity];
    }

    // O(1)
    @Override
    public int size() {
        return size;
    }

    // O(n) (причем O(1) для частного случая index == size)
    @Override
    public boolean add(int index, E element) {
        ensureCapacity();
        if (index == size) {
            elements[size++] = element;
            return true;
        }
        checkIndex(index);
        System.arraycopy(elements, index, elements, index + 1, size++ - index);
        elements[index] = element;
        return true;
    }

    // O(1) (в среднем; О(п) для редких предельных значений size)
    private void ensureCapacity() {
        if (size == MAX_ARRAY_SIZE) {
            throw new OutOfMemoryError();
        }
        if (size == elements.length) {
            int newCapacity = elements.length + elements.length / 2;
            if (newCapacity > MAX_ARRAY_SIZE || newCapacity < 0) {
                newCapacity = MAX_ARRAY_SIZE;
            }
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    // O(1)
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
    }

    // O(1)
    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    // O(n)
    @Override
    public int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o == elements[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    // O(n)
    @Override
    public int lastIndexOf(Object o) {
        if (o != null) {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o == elements[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    // O(n)
    @Override
    public E remove(int index) {
        // TO DO remove
        E res = (E) get(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
        elements[size] = null;
        return res;
    }

    // O(1)
    @Override
    public Iterator<E> iterator() {
        // TO DO iterator
        return new Iterator<E>() {
            private int i;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public E next() {
                return (E) elements[i++];
            }
        };
    }

    // O(n)
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    // O(1)
    @Override
    public E set(int index, E element) {
        E res = (E) get(index);
        elements[index] = element;
        return res;
    }
}
