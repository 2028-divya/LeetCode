class Solution {
    public int minimumRecolors(String blocks, int k) {

        int wCount = Integer.MAX_VALUE;
        int count = 0;

        int i = 0;
        int j = 0;
        int n = blocks.length();

        // First window
        for (j = 0; j < k; j++) {
            if (blocks.charAt(j) == 'W') {
                count++;
            }
        }

        wCount = count;

        // Slide the window
        while (j < n) {

            // Remove outgoing element
            if (blocks.charAt(i) == 'W') {
                count--;
            }

            // Add incoming element
            if (blocks.charAt(j) == 'W') {
                count++;
            }

            wCount = Math.min(wCount, count);

            i++;
            j++;
        }

        return wCount;
    }
}