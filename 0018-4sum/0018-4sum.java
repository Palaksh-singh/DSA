class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i<n; i++) {
            for (int j = i + 1; j<n; j++) {
                HashSet<Integer> seen = new HashSet<>();
                for (int k = j + 1; k<n; k++) {
                    long required = (long)target - (long)nums[i] - (long)nums[j] - (long)nums[k];
                    if (required >= Integer.MIN_VALUE && required <= Integer.MAX_VALUE && seen.contains((int) required)) {
                        List<Integer> ans = Arrays.asList(nums[i], nums[j], nums[k], (int)required);
                        Collections.sort(ans);
                        set.add(ans);
                    }
                    seen.add(nums[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }
}