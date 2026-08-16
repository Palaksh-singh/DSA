import java.util.*;
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        // Create start and end events
        for (int[] b : buildings) {
            int left = b[0];
            int right = b[1];
            int height = b[2];

            // Start event
            events.add(new int[]{left, -height});
            // End event
            events.add(new int[]{right, height});
        }

        // Sort by x-coordinate.
        // If x is same, sort by height.
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[1], b[1]);
        });

        // Max heap containing active building heights
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);

        List<List<Integer>> result = new ArrayList<>();
        int prevHeight = 0;

        for (int[] event : events) {
            int x = event[0];
            int h = event[1];

            // Building starts
            if (h < 0) {
                pq.add(-h);
            }

            // Building ends
            else {
                pq.remove(h);
            }

            // Current tallest building
            int currHeight = pq.peek();

            // Skyline changed
            if (currHeight != prevHeight) {
                result.add( Arrays.asList(x, currHeight) );
                prevHeight = currHeight;
            }
        }
        return result;
    }
}