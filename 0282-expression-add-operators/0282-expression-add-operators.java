class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        dfs(num, target, 0, 0, 0, "", res);
        return res;
    }

    private void dfs(String num, int target, int start, long current_value, long last_operand, String exp, List<String> res) {
        if (start == num.length() ) {
            if (current_value == target) {
                res.add(exp);
            }
            return;
        }

        for (int i = start; i < num.length(); i++) {
            if (i > start && num.charAt(start) == '0') return;

            String current_num = num.substring(start, i+1);
            long current_num_val = Long.parseLong(current_num);

            if (start == 0) {
                dfs(num, target, i+1, current_num_val, current_num_val, current_num, res);
            } else {
                dfs(num, target, i+1, current_value + current_num_val, current_num_val, exp + "+" + current_num, res);

                dfs(num, target, i+1, current_value - current_num_val, -current_num_val, exp + "-" + current_num, res);

                dfs(num, target, i+1, current_value - last_operand + last_operand * current_num_val, last_operand * current_num_val, exp + "*" + current_num, res);
            }
        }
    }
}