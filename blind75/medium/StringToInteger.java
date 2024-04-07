package blind75.medium;

public class StringToInteger {

    public int myAtoi(String s) {
        long res = 0;
        char[] trimmedNumberArray = s.trim().toCharArray();
        int length = trimmedNumberArray.length;

        int currentIndex = 0;
        while (currentIndex < length && !Character.isDigit(trimmedNumberArray[currentIndex]) && trimmedNumberArray[currentIndex] != '+' && trimmedNumberArray[currentIndex] != '-') {
            if(Character.isAlphabetic(trimmedNumberArray[currentIndex]) || trimmedNumberArray[currentIndex] == '.') {
                return 0;
            }
            currentIndex++;
        }

        boolean neg = false;
        if (currentIndex < length && trimmedNumberArray[currentIndex] == '-') {
            neg = true;
            currentIndex++;
        } else if(currentIndex < length && trimmedNumberArray[currentIndex] == '+') {
            currentIndex++;
        }

        if (currentIndex < length && !Character.isDigit(trimmedNumberArray[currentIndex]))
            return 0;

        while (currentIndex < length && Character.isDigit(trimmedNumberArray[currentIndex])) {
            res = res * 10 + trimmedNumberArray[currentIndex] - '0';

            if (!neg && res > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;

            if (neg && -res < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;

            currentIndex++;
        }

        return !neg ? (int)res : (int)-res;
    }
}
