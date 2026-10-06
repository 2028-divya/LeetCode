class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0;
        int i;
        int j = 0;
        for(i = 0;i<k;i++){
            sum += arr[i];
            j++;
        }
        if((sum/k)>= threshold){
            count++;
            
        }
        i = 0;
        while(j < arr.length){
            sum = sum + arr[j] - arr[i];
            if((sum/k)>= threshold){
            count++;
            }
            i++;
            j++;
        }
        return count;
    }
}