class Solution {
    List<String> ans = new ArrayList<>();
    int[] leds = {
        8, 4, 2, 1,
        32, 16, 8, 4, 2, 1
    };

    public List<String> readBinaryWatch(int turnedOn) {
        backtrack(0, turnedOn, 0, 0);
        return ans;
    }

    private void backtrack(int idx, int left, int hour, int minute) {

        if (left == 0) {
            if (hour < 12 && minute < 60) {
                ans.add(String.format("%d:%02d", hour, minute));
            }
            return;
        }

        if (idx == leds.length) {
            return;
        }

        if (leds.length - idx < left) {
            return;
        }

        backtrack(idx + 1, left, hour, minute);
        if (idx < 4) {
            backtrack(idx + 1, left - 1, hour + leds[idx], minute);
        } else {
            backtrack(idx + 1, left - 1, hour, minute + leds[idx]);
        }
    }
}