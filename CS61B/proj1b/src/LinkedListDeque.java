public class LinkedListDeque<T> implements Deque<T> {

    public deNode sentinel;
    int size;

    /*Creates an empty linked list deque.*/
    public LinkedListDeque() {
        sentinel = new deNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /*Creates a deep copy of other.*/
    public LinkedListDeque(LinkedListDeque other) {
        deNode sentinel = new deNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;

        this.sentinel = sentinel;
        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
        }
    }


    /*Adds an item of type T to the front of the deque.*/
    @Override
    public void addFirst(T item) {
        sentinel.next = new deNode(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size++;
    }

    /*Adds an item of type T to the back of the deque.*/
    @Override
    public void addLast(T item) {
        sentinel.prev = new deNode(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    /*Returns true if deque is empty, false otherwise.*/
//    public boolean isEmpty() {
////        return sentinel.next == sentinel;
//        return size == 0;
//    }

    /*Returns the number of items in the deque.*/
    @Override
    public int size() {
        return size;
    }

    /*Prints the items in the deque from first to last, separated by a space.
    Once all the items have been printed, print out a new line.*/
    @Override
    public void printDeque() {
        deNode p = sentinel.next;

        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    /*Removes and returns the item at the front of the deque. If no such item exists, returns null.*/
    @Override
    public T removeFirst() {
        T toRemove = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        if (!isEmpty()) {
            size -= 1;
        }
        return toRemove;
    }

    /*Removes and returns the item at the back of the deque. If no such item exists, returns null.*/
    @Override
    public T removeLast() {
        T toRemove = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        if (!isEmpty()) {
            size -= 1;
        }
        return toRemove;
    }

    /* Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
    If no such item exists, returns null. Must not alter the deque!*/
    @Override
    public T get(int index) {

        deNode p = sentinel.next;
        int n;
        for (n = 0; n < index; n++) {
            p = p.next;
            if (p == sentinel) {
                return null;
            }
        }
        return p.item;
    }

    /*Same as get, but uses recursion*/
    public T getRecursive(int index) {
        deNode p = sentinel.next;
        return getRecursive(index, p);
    }

    public T getRecursive(int index, deNode p) {
        if (index == 0) {
            return p.item;
        } else {
            return getRecursive(index - 1, p.next);
        }
    }

    public class deNode {
        T item;
        deNode prev;
        deNode next;

        public deNode(T item, deNode prev, deNode next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

//    public static void main(String[] args) {
//        LinkedListDeque<Integer> lb1 = new LinkedListDeque<Integer>();
//        for (int i = 3; i >= 0; i--) {
//            lb1.addFirst(i);
//        }
//        lb1.printDeque();
//        System.out.println(lb1.getRecursive(4));
//    }
}
