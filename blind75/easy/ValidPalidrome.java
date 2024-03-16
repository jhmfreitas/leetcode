package blind75.easy;

public class ValidPalidrome {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            char lChar = s.charAt(i);
            char rChar = s.charAt(j);
            if (!Character.isLetterOrDigit(lChar)) {
                i++;
            } else if (!Character.isLetterOrDigit(rChar)) {
                j--;
            } else if(Character.toLowerCase(lChar) != Character.toLowerCase(rChar)) {
                return false;
            } else {
                i++;
                j--;
            }
        }

        return true;
    }
}
