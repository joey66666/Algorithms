import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testWordPalindorm() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("rancor"));
        assertFalse(palindrome.isPalindrome("aaaaab"));

        assertTrue(palindrome.isPalindrome("abba"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome(""));
    }

//    @Test
//    public void testWordPalindorm2() {
//        OffByOne obo = new OffByOne();
//
//        assertFalse(palindrome.isPalindrome("cat", obo));
//        assertFalse(palindrome.isPalindrome("horse", obo));
//        assertFalse(palindrome.isPalindrome("rancor", obo));
//        assertFalse(palindrome.isPalindrome("aaaaab", obo));
//
//        assertTrue(palindrome.isPalindrome("abba", obo));
//        assertTrue(palindrome.isPalindrome("a", obo));
//        assertTrue(palindrome.isPalindrome("racecar", obo));
//        assertTrue(palindrome.isPalindrome("noon", obo));
//        assertTrue(palindrome.isPalindrome("", obo));
//    }

    @Test
    public void testWordPalindorm3() {
        CharacterComparator cc = new CharacterComparator() {
            @Override
            public boolean equalChars(char x, char y) {
                return x == y;
            }
        };


        assertFalse(palindrome.isPalindrome("cat", cc));
        assertFalse(palindrome.isPalindrome("horse", cc));
        assertFalse(palindrome.isPalindrome("rancor", cc));
        assertFalse(palindrome.isPalindrome("aaaaab", cc));

        assertTrue(palindrome.isPalindrome("abba", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("racecar", cc));
        assertTrue(palindrome.isPalindrome("noon", cc));
        assertTrue(palindrome.isPalindrome("", cc));
    }


}
//Uncomment this class once you've created your Palindrome class.