package blind75.easy;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        int carry = 0;

        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if(i >= 0) {
                sum += a.charAt(i--) - '0';
            }

            if(j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            res.insert(0, sum %2);
            carry = sum / 2; // sum = 0 -> 0, sum = 1 -> 0, sum = 2 -> 1, sum = 3 -> 1
        }


        if(carry == 1)
            res.insert(0, carry);

        return res.toString();
    }
}
