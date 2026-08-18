class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(n, 1, k, ans, new ArrayList<>());
        return ans;
    }

    private void findCombinations(int sum, int last, int k, List<List<Integer>> ans, List<Integer> ds) {
        if (sum == 0 && ds.size() == k) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        if (sum <= 0 || ds.size() > k) return;

        for (int i = last; i<=9; i++) {
            if (i <= sum) {
                ds.add(i);
                findCombinations(sum - i, i + 1, k, ans, ds);
                ds.remove(ds.size() - 1);
            } else {
                break;
            }
        }
    }
}