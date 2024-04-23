package blind75.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// O(4^N) where N is the number of digits
public class LetterCombinationsOfPhoneNumber {
    HashMap<Character, String> letters = new HashMap<>();
    int digitsSize;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty())
            return new ArrayList<>();

        letters.put('2', "abc");
        letters.put('3', "def");
        letters.put('4', "ghi");
        letters.put('5', "jkl");
        letters.put('6', "mno");
        letters.put('7', "pqrs");
        letters.put('8', "tuv");
        letters.put('9', "wxyz");
        digitsSize = digits.length();

        List<String> result = new ArrayList<>();
        lettersDfs(digits, new StringBuilder(), result, 0);
        return  result;
    }

    private void lettersDfs(String digits, StringBuilder currentCombination, List<String> result, int currentIndex) {
        if (currentCombination.length() == digitsSize) {
            result.add(currentCombination.toString());
            return;
        }

        for (int i = currentIndex; i < digits.length(); i++) {
            String numberLetters = letters.get(digits.charAt(i));
            for (int j = 0; j < numberLetters.length(); j++) {
                currentCombination.append(numberLetters.charAt(j));
                lettersDfs(digits, currentCombination, result, i + 1);
                currentCombination.setLength(currentCombination.length() - 1);
            }
        }
    }
}
