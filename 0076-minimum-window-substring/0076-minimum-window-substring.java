class Solution {
    public String minWindow(String s, String t) {
        int n = s.length(), m = t.length();
        int[] hash = new int[256];
        int left = 0, minLen = Integer.MAX_VALUE, StartIndex = -1, cnt = 0;
        for (int i = 0; i<m; i++) {
            hash[t.charAt(i)]++;
        }
        for (int right = 0; right < n; right++) {
            if (hash[s.charAt(right)] > 0) {
                cnt = cnt + 1;
            }

            hash[s.charAt(right)]--;

            while (cnt == m) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    StartIndex = left;
                }
                hash[s.charAt(left)]++;
                if (hash[s.charAt(left)] > 0) cnt = cnt - 1;
                left++;
            }
        }
        return StartIndex == -1 ? "" : s.substring(StartIndex, StartIndex + minLen);
    }
}