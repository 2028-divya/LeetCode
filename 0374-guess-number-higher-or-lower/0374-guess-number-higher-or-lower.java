/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        // Search range: numbers from 1 to n.
        int start=1;
        int end=n;

        while(start<=end) {

            // Calculate the middle number safely.
            int mid = start + ((end - start)/ 2);

            // Get Guess result from the Guess API.
            int guessResult = guess(mid);

            // Correct guess found.
            if (guessResult == 0) {
                return mid;
            }

            // Secret number is greater than the current guess.
            else if (guessResult == 1) {
                start = mid + 1;
            }

            // Secret number is smaller than the current guess.
            else {
                end = mid - 1;
            }
        }

        // Unreachable because the problem guarantees a valid answer.
        return -1;
    }
}