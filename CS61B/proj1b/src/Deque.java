public interface Deque<T> {

    default boolean isEmpty() {
        return size() == 0;
    }

    void addLast(T item);

    void addFirst(T item);

    T removeLast();

    int size();

    T removeFirst();

    T get(int index);

    void printDeque();

}
