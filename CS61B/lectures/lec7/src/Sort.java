public class Sort {

    /* Return the smallest string in x */
    public static int findSMallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start; i < x.length; i++) {
            int cmp = x[i].compareTo(x[smallestIndex]);
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void swap(String[] x, int a, int b) {
        String temp = x[b];
        x[b] = x[a];
        x[a] = temp;
    }

    public static void sort(String[] x) {
        sort(x, 0);
    }

    private static void sort(String[] x, int start) {
        if (start == x.length) {
            return;
        }
        int smallestIndex = findSMallest(x, start);
        swap(x, start, smallestIndex);
        sort(x, start + 1);
    }
}
