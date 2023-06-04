import java.util.* ;
import java.io.*; 

 class Solution {
	
	public static long maxSubarraySum(int[] arr, int n) {
		long maxSum = 0;
        long currSum = arr[0];
        maxSum = Math.max(currSum, maxSum);
        for(int i = 1; i < n; i++){
            if(currSum < 0){
                currSum = 0;
            }
            currSum += arr[i];
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
	}

}
