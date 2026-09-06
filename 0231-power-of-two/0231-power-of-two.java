class Solution {
    public boolean isPowerOfTwo(int n) {
        boolean flag;

        if (n > 0 && (n & (n - 1)) == 0) {
            flag = true;
        } else {
            flag = false;
        }

        return flag;
    }
}