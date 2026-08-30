/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null) return ans;

        StringBuilder path = new StringBuilder();
        dfs(root, path, ans);

        return ans;
    }

    private void dfs(TreeNode node, StringBuilder path, List<String> ans) {
        int len = path.length();

        if (len == 0) path.append(node.val);
        else path.append("->").append(node.val);

        if (node.left == null && node.right == null) ans.add(path.toString());
        else {
            if (node.left != null) {
                dfs(node.left, path, ans);
            }
            if (node.right != null) {
                dfs(node.right, path, ans);
            }
        }
        path.setLength(len);
    }
}