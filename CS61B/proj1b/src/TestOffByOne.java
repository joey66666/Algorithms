import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        assertFalse(offByOne.equalChars('a', 'b'));
        assertFalse(offByOne.equalChars('A', 'B'));
        assertFalse(offByOne.equalChars('1', '2'));


        assertTrue(offByOne.equalChars('A', 'A'));
        assertTrue(offByOne.equalChars('1', '1'));
        assertTrue(offByOne.equalChars('b', 'b'));
    }

    @Test
    public void testEqualCharsByOne() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('r', 'q'));
        assertTrue(offByOne.equalChars('&', '%'));


        assertFalse(offByOne.equalChars('a', 'e'));
        assertFalse(offByOne.equalChars('z', 'a'));
        assertFalse(offByOne.equalChars('a', 'a'));
    }


}
//Uncomment this class once you've created your CharacterComparator interface and OffByOne class.