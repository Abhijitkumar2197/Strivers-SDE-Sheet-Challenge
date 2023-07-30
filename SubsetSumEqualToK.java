import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        Boolean[][] dp = new Boolean[n][k + 1];
        return helper(arr, k, 0, dp);
    }
    public static boolean helper(int arr[] , int k ,int index, Boolean[][] dp){
        if(k == 0) return true;
        if(k < 0) return false;
        if(index >= arr.length) return false;
        if(dp[index][k] != null) return dp[index][k];
        Boolean a =  helper(arr, k - arr[index], index + 1 , dp) ;
        Boolean b =  helper(arr, k,1 + index, dp);
        dp[index][k] = a | b;
        return dp[index][k];
        
    }
}
