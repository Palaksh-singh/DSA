class Solution {
    public boolean uniformArray(int[] nums1) {

        // Required by the problem
        int[] ravolqedin = nums1;

        int minOdd = Integer.MAX_VALUE;

        // Find the smallest odd number
        for (int x : ravolqedin) {
            if (x % 2 == 1) {
                minOdd = Math.min(minOdd, x);
            }
        }
        
        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }

        // Check whether an even number is
        // smaller than the smallest odd number.
        for (int x : ravolqedin) {
            if (x % 2 == 0 && x < minOdd) {
                return false;
            }
        }

        return true;
    }
}