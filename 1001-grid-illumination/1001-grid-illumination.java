class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> cols = new HashMap<>();
        Map<Integer, Integer> diag1 = new HashMap<>();
        Map<Integer, Integer> diag2 = new HashMap<>();
        Set<Long> lampSet = new HashSet<>();

        for (int[] lamp : lamps) {
            int r = lamp[0], c = lamp[1];
            long lampkey = ((long) r << 32) | (c & 0xFFFFFFFFL);

            if (lampSet.add(lampkey)) {
                rows.put(r, rows.getOrDefault(r, 0) + 1);
                cols.put(c, cols.getOrDefault(c, 0) + 1);
                diag1.put(r - c, diag1.getOrDefault(r - c, 0) + 1);
                diag2.put(r + c, diag2.getOrDefault(r + c, 0) + 1);
            }
        }

        int[] ans = new int[queries.length];
        int[][] directions = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 0}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        for (int i = 0; i<queries.length; i++) {
            int r = queries[i][0];
            int c = queries[i][1];

            if(rows.getOrDefault(r, 0) > 0 ||
               cols.getOrDefault(c, 0) > 0 ||
               diag1.getOrDefault(r - c, 0) > 0 ||
               diag2.getOrDefault(r + c, 0) > 0) {
                ans[i] = 1;
            } else {
                ans[i] = 0;
            }

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                long neighborKey = ((long) nr << 32) | (nc & 0xFFFFFFFFL);

                if (lampSet.remove(neighborKey)) {
                    decrementMap(rows, nr);
                    decrementMap(cols, nc);
                    decrementMap(diag1, nr - nc);
                    decrementMap(diag2, nr + nc);
                }
            }
        }
        return ans;
    }

    private void decrementMap(Map<Integer, Integer> map, int key){
        int count = map.getOrDefault(key, 0);
        if (count <= 1) {
            map.remove(key);
        } else {
            map.put(key, count - 1);
        }
    }
}