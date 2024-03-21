package blind75.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    // My first version
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] res = new int[1][];
            res[0] = newInterval;
            return res;
        }

        int[][] mergedIntervals = new int[intervals.length+1][2];
        int mergedIntervalsCount = 0;
        int i = 0;

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            mergedIntervals[mergedIntervalsCount] = intervals[i];
            i++;
            mergedIntervalsCount++;
        }

        mergedIntervals[mergedIntervalsCount][0] =  i < intervals.length ?  Math.min(intervals[i][0], newInterval[0]) : newInterval[0];
        mergedIntervals[mergedIntervalsCount][1] = newInterval[1];
        while (i < intervals.length && overlaps(intervals[i], newInterval)) {
            mergedIntervals[mergedIntervalsCount][1] = Math.max(mergedIntervals[mergedIntervalsCount][1], intervals[i][1]);
            i++;
        }

        mergedIntervalsCount++;
        while (i < intervals.length) {
            mergedIntervals[mergedIntervalsCount] = intervals[i];
            i++;
            mergedIntervalsCount++;
        }

        return Arrays.copyOf(mergedIntervals, mergedIntervalsCount);
    }

    // Improved version with list
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][] { newInterval };
        }

        List<int[]> mergedIntervals = new ArrayList<>();
        int i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            mergedIntervals.add(intervals[i]);
            i++;
        }

        // The trick here is to modify the newInterval instead of trying to modify an added interval to the list
        while (i < intervals.length && overlaps(intervals[i], newInterval)) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        mergedIntervals.add(newInterval);

        while (i < intervals.length) {
            mergedIntervals.add(intervals[i]);
            i++;
        }

        return mergedIntervals.toArray( new int[mergedIntervals.size()][]);
    }

    public boolean overlaps(int[] interval1, int[] interval2) {
        return !(interval1[1] < interval2[0] || interval1[0] > interval2[1]);
    }
}
