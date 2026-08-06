class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (p.length() > s.length()) return ans;

        int[] need = new int[26];
        int[] window = new int[26];

        for (char ch : p.toCharArray()) {
            need[ch - 'a']++;
        }

        int left = 0;
        for (int right = 0; right<s.length(); right++) {
            window[s.charAt(right) - 'a']++;
            if (right - left + 1 > p.length()) {
                window[s.charAt(left) - 'a']--;
                left++;
            }
            if (right - left + 1 == p.length()) {
                if (matches(need, window)) {
                    ans.add(left);
                }
            }
        }
        return ans;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i<26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}