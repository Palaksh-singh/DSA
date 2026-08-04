class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // We are in the decreasing part
                high = mid;
            } else {
                // We are in the increasing part
                low = mid + 1;
            }
        }

        // low == high -> peak index
        return low;
    }
}
