import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) return new int[0][0];

        // 1. Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        // 2. Traverse intervals
        for (int i = 1; i < intervals.length; i++) {

            // Overlapping case
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            }
            // Non-overlapping case
            else {
                result.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add last interval
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}
