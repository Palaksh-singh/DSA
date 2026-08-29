class Solution {

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {

        int n = nums.length;

        // Store {value, original index}
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = nums[i];
            a[i][1] = i;
        }

        // Sort by value
        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));

        int i = 0;

        while (i < n) {

            int j = i;

            // Find one connected group
            while (j + 1 < n &&
                   a[j + 1][0] - a[j][0] <= limit) {
                j++;
            }

            // Collect original indices of this group
            int[] indices = new int[j - i + 1];

            for (int k = i; k <= j; k++) {
                indices[k - i] = a[k][1];
            }

            // Sort indices so smallest values
            // go to earliest positions
            Arrays.sort(indices);

            // Values are already sorted because a[] is sorted
            for (int k = i; k <= j; k++) {
                nums[indices[k - i]] = a[k][0];
            }

            i = j + 1;
        }

        return nums;
    }
}