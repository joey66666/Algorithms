public class ArrayDequeTest {


    public static void main(String[] args) {
        ArrayDeque ad = new ArrayDeque();
        for (int i = 0; i < 9; i++) {
            ad.add(i);
        }
        ad.add(1);
        ad.add(5);
        ad.add(10);
        ad.remove();
        ad.remove();
//        System.out.println(ad.get(3));
////        System.out.println(ad.get(10));
        ArrayDeque ad2 = new ArrayDeque(ad);

    }
}
