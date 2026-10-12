class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int alreadyHappy = 0;

        // Count customers already satisfied
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                alreadyHappy += customers[i];
            }
        }

        // Calculate additional satisfied customers in first window
        int count = 0;

        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                count += customers[i];
            }
        }

        int max = count;

        // Slide the window
        int i = 0;
        int j = minutes;

        while (j < n) {
            // Remove outgoing customer contribution
            if (grumpy[i] == 1) {
                count -= customers[i];
            }

            // Add incoming customer contribution
            if (grumpy[j] == 1) {
                count += customers[j];
            }

            max = Math.max(max, count);

            i++;
            j++;
        }

        return alreadyHappy + max;
    }
}