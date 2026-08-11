class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        if (m < 3 || n < 3) return 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{heightMap[i][0], i, 0});
            pq.offer(new int[]{heightMap[i][n - 1], i, n - 1});

            vis[i][0] = true;
            vis[i][n - 1] = true;
        }

        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{heightMap[0][j], 0, j});
            pq.offer(new int[]{heightMap[m - 1][j], m - 1, j});

            vis[0][j] = true;
            vis[m - 1][j] = true;
        }

        int water = 0;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            int height = current[0];
            int row = current[1];
            int col = current[2];

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || vis[newRow][newCol]) {
                    continue;
                }

                vis[newRow][newCol] = true;

                int neighborHeight = heightMap[newRow][newCol];

                if (neighborHeight < height) {
                    water += height - neighborHeight;
                }

                int newHeight = Math.max(height, neighborHeight);

                pq.offer(new int[]{
                    newHeight,
                    newRow,
                    newCol
                });
            }
        }
        return water;
    }
}