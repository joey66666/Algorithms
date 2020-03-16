package HW0;

import static java.lang.System.exit;

public class Exercise1 {


    public static void main(String[] args) {
        int line=4;
        for (int i = 0; i <= line; i++) {
            for (int j = 0; j <= i; j++){
                System.out.print('*');
            }
            if(i==4){
                exit(0);
            }
            System.out.println();
        }
    }
}
