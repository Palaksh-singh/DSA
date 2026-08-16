import java.util.*;
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        // Create start and end events
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); // start
            events.add(new int[]{b[1], b[2]});  // end
        }

        // Sort by x, then height
        Collections.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        // TreeMap acts like a multiset:
        // key   = height
        // value = number of buildings having that height
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Ground level
        map.put(0, 1);

        List<List<Integer>> result = new ArrayList<>();

        int prevHeight = 0;

        for (int[] event : events) {

            int x = event[0];
            int h = event[1];

            if (h < 0) {
                // Building starts
                h = -h;

                map.put(h, map.getOrDefault(h, 0) + 1);

            } else {
                // Building ends
                int count = map.get(h);

                if (count == 1) {
                    map.remove(h);
                } else {
                    map.put(h, count - 1);
                }
            }

            // Highest active building
            int currHeight = map.lastKey();

            // Skyline changed
            if (currHeight != prevHeight) {
                result.add(Arrays.asList(x, currHeight));
                prevHeight = currHeight;
            }
        }

        return result;
    }
}