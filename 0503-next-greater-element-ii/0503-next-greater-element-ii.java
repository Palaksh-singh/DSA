class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];

        for (int i = 2*n-1; i>=0; i--) {
            int ind = i%n;
            int curr = nums[ind];

            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }

            if (i < n) {
                if (stack.isEmpty()) {
                    ans[ind] = -1;
                } else {
                    ans[ind] = stack.peek();
                }
            }
            stack.push(curr);
        }
        return ans;
    }
}