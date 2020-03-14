package HW0;

public class Exercise2 {
    /**
     * Returns the maximum value from m.
     */
    public static int max(int[] m) {
        if (m.length == 0) {
            return 0;
        }
        int i = 0;
        int num = -1;
        while (i < m.length) {
            if (num < m[i]) {
                num = m[i];
            }
            i = i + 1;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6, 0};
        int max_num = max(numbers);
        System.out.println(max_num);
    }
}