import java.util.*;

class Solution {
    public int findTheLongestSubstring(String s) {
        int[] seen = new int[32];
        Arrays.fill(seen, -1);
        
        seen[0] = -1;
        
        int mask = 0;
        int maxLen = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == 'a') mask ^= (1 << 0);
            else if (c == 'e') mask ^= (1 << 1);
            else if (c == 'i') mask ^= (1 << 2);
            else if (c == 'o') mask ^= (1 << 3);
            else if (c == 'u') mask ^= (1 << 4);
            
            if (seen[mask] != -1 || mask == 0) {
                maxLen = Math.max(maxLen, i - seen[mask]);
            } else {
                seen[mask] = i;
            }
        }
        
        return maxLen;
    }
}