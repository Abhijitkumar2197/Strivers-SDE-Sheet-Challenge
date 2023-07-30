import java.util.Arrays;
public class Solution {

    public static int cutLogs(int k, int n) {
        int[][] dp = new int[n + 1][k + 1];
        for(int[] a : dp) Arrays.fill(a, -1);
        return helper(k, n, dp);
        
    }
    public static int helper(int k , int n , int[][] dp ){
        if(n <= 0 || k <= 0) return 0;
        if(k ==1) return n;
        if(n == 1) return 1;
        if(dp[n][k] != -1) return dp[n][k];
        int mini = Integer.MAX_VALUE;
        
        int start = 1;
        int end = n;
        while(start <= end){
            int mid = (start + end)/2;
            int broken = helper(k - 1, mid - 1,dp);
            int notbroken = helper(k, n - mid , dp);
            int min = Math.max(broken, notbroken);
            mini = Math.min(min + 1, mini);

            if(broken < notbroken){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        dp[n][k] = mini;
        return dp[n][k];
    }

}
