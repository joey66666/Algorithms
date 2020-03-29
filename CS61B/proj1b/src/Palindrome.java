/* A class for palindrome operations */
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque deque = new LinkedListDeque<String>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque wordDeque = wordToDeque(word);
        String reverseWord = "";
        for (int i = 0; i < word.length(); i++) {
            reverseWord += wordDeque.removeLast();
        }
        return (reverseWord.equals(word));
    }

//    public boolean isPalindrome(String word, OffByOne obo) {
//        if (word.length() == 0 || word.length() == 1) {
//            return true;
//        }
//        int wordLength = word.length();
//        for (int i = 0; i < word.length(); i++) {
//            boolean flag = obo.equalChars(word.charAt(i), word.charAt(wordLength - i - 1));
//            if (flag == true) {
//                continue;
//            } else {
//                return false;
//            }
//        }
//        return true;
//    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        int wordLength = word.length();
        for (int i = 0; i < word.length(); i++) {
            boolean flag = cc.equalChars(word.charAt(i), word.charAt(wordLength - i - 1));
            if (flag == true) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }


}
