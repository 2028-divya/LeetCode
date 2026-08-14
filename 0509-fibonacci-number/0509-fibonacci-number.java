class Solution {
    public int fib(int n) {
        // Base Cases
        if (n <= 1) return n;
        
        // Recursive Relation
        return fib(n - 1) + fib(n - 2);
    } 
}