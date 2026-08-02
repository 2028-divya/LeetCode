class Solution {

    // This function checks if we can place all the balls
    // such that the minimum distance between any two balls is at least 'mid'
    public static boolean isValidDistance(int[] position, int m, int mid) {

        // First ball is always placed at the first stall
        int ballsPlaced = 1;

        // Stores the index of the last stall where a ball was placed
        int lastPosition = 0;

        // Start checking from the second stall
        for (int i = 1; i < position.length; i++) {

            // Check if the current stall is at least 'mid' distance away
            // from the last placed ball
            if (position[i] - position[lastPosition] >= mid) {

                // Place the ball here
                ballsPlaced++;

                // Update the last placed ball index
                lastPosition = i;

                // If all balls are placed successfully
                if (ballsPlaced == m) {
                    return true;
                }
            }
        }

        // Not enough balls could be placed
        return false;
    }

    public int maxDistance(int[] position, int m) {

        // Sort the stalls so that distances can be checked correctly
        Arrays.sort(position);

        int n = position.length;

        // Minimum possible distance between two balls
        int start = 1;

        // Maximum possible distance (last stall - first stall)
        int end = position[n - 1] - position[0];

        // Stores the best answer found so far
        int ans = -1;

        // Binary Search on the answer
        while (start <= end) {

            // Guess the minimum distance
            int mid = start + (end - start) / 2;

            // Check if this distance is possible
            if (isValidDistance(position, m, mid)) {

                // Save this answer
                ans = mid;

                // Try to find a larger minimum distance
                start = mid + 1;
            } else {

                // Distance is too large, try a smaller one
                end = mid - 1;
            }
        }

        // Return the maximum possible minimum distance
        return ans;
    }
}