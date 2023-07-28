import java.util.*;
public class Solution {

	public static int longestIncreasingSubsequence(int arr[]) {
		int[] dp = new int[arr.length];
        int n = arr.length;
        Arrays.fill(dp, 1);
        for(int i = n - 1; i >= 0; i--){
            for( int j  = i; j >= 0 ; j--){
                if(arr[j] < arr[i] ){
                    dp[j] = Math.max(dp[j] , dp[i] + 1);
                }
            }
        }
        int max = 1;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, dp[i]);
        }
        return max;
	}

}
