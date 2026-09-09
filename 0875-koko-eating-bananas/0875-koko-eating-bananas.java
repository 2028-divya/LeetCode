class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int maximumPile = 0;

        // Find the maximum pile size.

        for (int pile : piles) {

            if (pile > maximumPile) {
                maximumPile = pile;
            }
        }

        int left = 1;
        int right = maximumPile;

        // Binary search for the minimum valid eating speed.
        while (left <= right) {

            int eatingSpeed = left + (right - left) / 2;
            long requiredHours = 0;

            // Calculate total hours needed at this speed.
            for (int pile : piles) {
                requiredHours += (pile + eatingSpeed - 1) / eatingSpeed;
            }

            if (requiredHours <= h) {
                // This speed works, so try a smaller speed.
                right = eatingSpeed - 1;
            } else {
                // This speed is too slow, so increase the speed.
                left = eatingSpeed + 1;
            }
        }

        return left;
    }
}