import java.util.*;

/**
 * Class TypedSet<T>
 * Implements the interface based on a regular array
 * @param <T>
 */

public class TypedSet<T> implements Set<T> {
    // Initial array size
    private static final int INITIAL_CAPACITY = 15;

    // Magnification factor
    private static final double GROWTH_FACTOR = 1.3;

    // Array for storing elements
    private Object[] data;

    // Current number of items
    private int size;

    // Default constructor
    public TypedSet() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // A constructor that takes one element
    public TypedSet(T element) {
        this();
        add(element);
    }

    // A constructor that accepts a standard collection
    public TypedSet(Collection<? extends T> collection) {
        this();
        addAll(collection);
    }

    // Checks if such an element exists in the collection
    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data[i], o)) return true;
        }
        return false;
    }

    // Adds an element if it doesn't already exist
    @Override
    public boolean add(T element) {
        if (contains(element)) return false;
        ensureCapacity();
        data[size++] = element;
        return true;
    }

    // Adds all items from another collection
    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T e : c) {
            if (add(e)) modified = true;
        }
        return modified;
    }

    // Increases the size of the array when needed
    private void ensureCapacity() {
        if (size >= data.length) {
            int newCapacity = (int) Math.ceil(data.length * GROWTH_FACTOR);
            data = Arrays.copyOf(data, newCapacity);
        }
    }

    // Deletes an item
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(data[i], o)) {
                System.arraycopy(data, i + 1, data, i, size - i - 1);
                data[--size] = null;
                return true;
            }
        }
        return false;
    }

    // Returns the number of elements
    @Override
    public int size() {
        return size;
    }

    // Checks if the collection is empty
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Cleans up the collection
    @Override
    public void clear() {
        Arrays.fill(data, 0, size, null);
        size = 0;
    }

    // Returns an iterator
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }
            @Override
            @SuppressWarnings("unchecked")
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                return (T) data[index++];
            }
        };
    }

    // Converts to an array
    @Override
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    // Converts to a typed array
    @Override
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] a) {
        if (a.length < size) {
            return (E[]) Arrays.copyOf(data, size, a.getClass());
        }
        System.arraycopy(data, 0, a, 0, size);
        if (a.length > size) a[size] = null;
        return a;
    }

    // Checks if all elements are contained
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) return false;
        }
        return true;
    }

    // Deletes all items in the collection.
    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        for (Object o : c) {
            if (remove(o)) changed = true;
        }
        return changed;
    }

    // Keeps only those elements that are in the given collection
    @Override
    public boolean retainAll(Collection<?> c) {
        boolean changed = false;
        for (int i = 0; i < size; i++) {
            if (!c.contains(data[i])) {
                remove(data[i--]);
                changed = true;
            }
        }
        return changed;
    }

    // Convenient line representation
    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }
}
