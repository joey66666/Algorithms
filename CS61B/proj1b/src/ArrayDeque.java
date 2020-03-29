public class ArrayDeque<T> implements Deque<T> {
    private int nextFirst;
    private int nextLast;
    private T[] items;
    private int size;


    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }

    public ArrayDeque(ArrayDeque other) {
        this.items = (T[]) new Object[other.items.length];
        this.size = other.size;
        this.nextFirst = other.nextFirst;
        this.nextLast = other.nextLast;
        System.arraycopy(other.items, 0, this.items, 0, other.size);
    }

    public int addOne(int x) {
        return (x + 1) % items.length;
    }

    public int minusOne(int x) {
        return (x - 1 + items.length) % items.length;
    }

    public boolean isFull() {
        return (size == items.length);
    }

//    public boolean isEmpty() {
//        return size == 0;
//    }

    public boolean isEfficient() {
        return size >= 16 && (size / items.length) < 0.25;
    }

    public void resize(int newSize) {
        T[] a = (T[]) new Object[newSize];
        int oldIndex = addOne(nextFirst);
        for (int newIndex = 0; newIndex < size; newIndex++) {
            a[newIndex] = items[oldIndex];
            oldIndex = addOne(oldIndex);
            size++;
        }
        items = a;
        nextFirst = newSize - 1;
        nextLast = size;

    }

    @Override
    public void addLast(T item) {
        if (isFull()) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = addOne(nextLast);
        size += 1;
    }

    @Override
    public void addFirst(T item) {
        if (isFull()) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    @Override
    public T removeLast() {
        if (!isEfficient()) {
            resize(size / 2);
        }
        int removeIndex = minusOne(nextLast);
        T removeItem = items[removeIndex];
        items[removeIndex] = null;

        if (!isEmpty()) {
            size -= 1;
        }
        return removeItem;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (!isEfficient()) {
            resize(size / 2);
        }
        int removeIndex = addOne(nextFirst);
        T removeItem = items[removeIndex];
        items[removeIndex] = null;

        if (!isEmpty()) {
            size -= 1;
        }
        return removeItem;
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        int start = addOne(nextFirst);
        return items[(start + index) % items.length];
    }

    @Override
    public void printDeque() {
        for (int i = addOne(nextFirst); i != nextLast; i = addOne(i)) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}