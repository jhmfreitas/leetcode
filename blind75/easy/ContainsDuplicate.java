package blind75.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    // HashMap solution
    public boolean containsDuplicate(int[] nums) {
        boolean res = false;
        HashMap<Integer, Integer> occurrence = new HashMap<>();
        for (int num : nums) {
            if(occurrence.containsKey(num)) {
                return true;
            } else {
                occurrence.put(num, 1);
            }
        }
        return res;
    }

    // HashSet Solution
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> occurrence = new HashSet<>();
        for (int num : nums) {
            if(!occurrence.add(num)) {
                return true;
            }
        }
        return false;
    }

}
