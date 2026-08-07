class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0, left = 0, zeros = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;
            if (zeros > k) {
                if (nums[left] == 0) zeros--;
                left++;
            }
            if (zeros <= k) maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}