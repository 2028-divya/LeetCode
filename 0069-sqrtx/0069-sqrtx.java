class Solution {

    public int mySqrt(int x) {

        // Handle the smallest inputs directly.
        if (x == 0 || x == 1) {
            return x;
        }

        int floorSqrt = -1;

        // Possible answers lie between 1 and x.
        int start = 1;
        int end = x;

        while (start <= end) {

            // Prevent integer overflow while calculating mid.
            int mid = start + (end - start) / 2;

            // Exact square root found
            if (mid == x / mid) {
                return mid;
            }

           // mid is bigger than sqrt(x)
            else if (mid > x / mid) {
                end = mid - 1;
            }

            // mid can be the answer, but maybe there's a bigger one
            else {
                floorSqrt = mid;
                start = mid + 1;
            }
        }

        return floorSqrt;
    }
}