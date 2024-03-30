package blind75.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0]-b[0]); // sorting method more efficient than using Integer.comparingInt

        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastMergedInterval = output.get(output.size() - 1);
            int[] current = intervals[i];

            if(lastMergedInterval[1] < current[0]){ // more efficient than using overlaps function
                output.add(current);
            } else {
                lastMergedInterval[1] = Math.max(current[1], lastMergedInterval[1]);
            }
        }

        return output.toArray(new int[output.size()][2]);
    }

    private boolean overlaps(int[] interval1, int[] interval2) {
        return !(interval1[1] < interval2[0] || interval1[0] > interval2[1]);
    }
}
