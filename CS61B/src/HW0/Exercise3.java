package HW0;

public class Exercise3 {
    /**
     * Returns the maximum value from m using for loop.
     */
    public static int forMax(int[] m) {
        if (m.length == 0) {
            return 0;
        }
        int num = -1;
        for (int i = 0; i < m.length; i++) {
            if (m[i] > num) {
                num = m[i];
            }
        }
        return num;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        int max_num = forMax(numbers);
        System.out.println(max_num);
    }
}
