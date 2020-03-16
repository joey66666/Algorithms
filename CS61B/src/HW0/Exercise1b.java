package HW0;

import static java.lang.System.exit;

public class Exercise1b {
    public static void drawTriangle(int m) {

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print('*');
            }
            if (i == m) {
                exit(0);
            }
            System.out.println();
        }


    }


    public static void main(String[] args) {
//        drawTriangle(5);
        drawTriangle(10);

    }
}
