import org.junit.Test;

import static org.junit.Assert.*;

public class TestSort {

    @Test
    public void testSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;
        int smallestIndex = Sort.findSMallest(input, 2);
        assertEquals(smallestIndex, expected);
    }

    @Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
//        String[] expected = {"i", "have", "an", "egg"};
        String[] expected = {"an", "have", "i", "egg"};
        Sort.swap(input, 0, 2);assertArrayEquals(input, expected);

    }

    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
//        String[] expected = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);
//        System.out.println(Arrays.toString(input));
        assertArrayEquals(input, expected);
    }

//    public void main(String[] args) {
//        testSmallest();
//        testSwap();
//        testSort();
//    }
}
