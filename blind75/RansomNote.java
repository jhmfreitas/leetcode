package blind75;

import java.util.HashMap;

public class RansomNote {

    HashMap<Character, Integer> letterCount = new HashMap();
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] magazineChars = magazine.toCharArray();
        for (char c: magazineChars) {
            if(letterCount.containsKey(c)) {
                Integer count = letterCount.get(c);
                letterCount.put(c, count + 1);
            } else {
                letterCount.put(c, 1);
            }
        }

        char[] ransomChars = ransomNote.toCharArray();
        for (char c: ransomChars) {
            if(!letterCount.containsKey(c)) {
                return false;
            } else if(letterCount.get(c) == 0){
                return false;
            } else {
                letterCount.put(c, letterCount.get(c) - 1);
            }
        }

        return true;
    }

    // Efficient version
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length())
            return false;

        int[] count = new int[26];

        for (char c : magazine.toCharArray()) {
            count[ c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()){
            count[ c - 'a']--;
            if(count[c - 'a'] < 0)
                return false;
        }

        return true;
    }
}
