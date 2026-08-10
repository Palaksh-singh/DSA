class Solution {
    private int helper(int[] nums, int goal) {
        if (goal < 0) return 0;
        int left = 0, sum = 0, cnt = 0;
        for (int right = 0; right<nums.length; right++) {
            sum += (nums[right] % 2);
            while (sum > goal) {
                sum = sum - (nums[left] % 2);
                left = left + 1;
            }
            cnt = cnt + (right - left + 1);
        }
        return cnt;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }
}