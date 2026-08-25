class Solution {
    List<Integer>[] graph;
    int[] size;
    int[] ans;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        graph = new ArrayList[n];
        size = new int[n];
        ans = new int[n];

        for (int i = 0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }
        
        dfs1(0, -1);
        dfs2(0, -1);
        
        return ans;
    }

    private void dfs1(int node, int parent) {
        size[node] = 1;
        for (int child : graph[node]) {
            if (child == parent) continue;
            dfs1(child, node);
            size[node] += size[child];
            ans[0] += ans[child] + size[child];
        }
    }

    private void dfs2(int node, int parent) {
        for (int child : graph[node]) {
            if (child == parent) continue;
            ans[child] = ans[node] + size[0] - (2 * size[child]);
            dfs2(child, node);
        }
    }
}