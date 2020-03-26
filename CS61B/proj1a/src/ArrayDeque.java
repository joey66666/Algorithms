public class ArrayDeque {
    int nextFirst;
    int nextLast;
    private int[] items;
    private int size;


    public ArrayDeque() {
        items = new int[8];
        size = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        // items2长度 = size长度，去除后面为空的冗余
//        int[] items2 = new int[other.size()];

        // items2长度 = other长度literally
        int[] items2 = new int[other.items.length];
        System.arraycopy(other.items, 0, items2, 0, other.size());
        this.items = items2;
        this.size = other.size();
//        return items2;
    }

    public void add(int x) {
        items[size] = x;
        size += 1;
        if (size == items.length) {
            resize();
        }
    }

    public void resize() {
        int[] a = new int[size * 2];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void remove() {
        items[size - 1] = 0;
        size -= 1;
    }

    public int get(int index) {
        return items[index];
    }

    public int size() {
        return size;
    }


}
