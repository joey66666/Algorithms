import java.util.Arrays;

public class Array {
    public static int[] insert(int[] arr, int item, int position) {
        int[] newArray = new int[arr.length + 1];

        if (position > arr.length) {
            System.arraycopy(arr, 0, newArray, 0, arr.length);
            newArray[arr.length] = item;
            return newArray;
        }

        int i = 0;
        while (i < position) {
            newArray[i] = arr[i];
            i += 1;
        }

        newArray[i] = item;
        System.arraycopy(arr, i, newArray, i + 1, arr.length - i);
        return newArray;
    }

    public static void reverse(int[] arr) {
        int mid = arr.length / 2;
        int first = 0;
        int last = arr.length - 1;
        while (first < mid) {
            int tmp = arr[first];
            arr[first] = arr[last];
            arr[last] = tmp;
            first++;
        }
    }

    /**
     * [3, 2,1] ->  [3, 3, 3, 2, 2, 1]
     * non-destructive
     */

    public static int[] replicate(int[] arr) {
        int total = 0;
        for (int item : arr) {
            total += item;
        }
        int[] newArr = new int[total];

        int b = 0;
//        for (int item : arr) {
//            for (int i = 0; i < item; i++) {
//                newArr[b] = item;
//                b++;
//            }
//        }
        for (int i = 0; i < arr.length; i++) {
            for (int a = 0; a < arr[i]; a++) {
                newArr[b] = arr[i];
                b++;
            }
        }
        return newArr;

    }

    public void testRecerse() {
        int[] array = {5, 9, 10, 14, 15};
        System.out.println(Arrays.toString(array));
        reverse(array);
        System.out.println(Arrays.toString(array));
    }

    public void testReplicate() {
        int[] a = {3, 2, 1};
        int[] newA = replicate(a);
        System.out.println(Arrays.toString(newA));
    }

    public static void main(String[] args) {
        Array a = new Array();
        a.testReplicate();

    }
}
