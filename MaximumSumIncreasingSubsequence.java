import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
    public static int maxIncreasingDumbbellsSum(ArrayList<Integer> rack, int n) {
        int[] dp = new int[n];
        dp[n - 1] = rack.get(n - 1);
        for(int i = 0 ; i< n ;i ++) dp[i] = rack.get(i);
        for(int i = n -2; i >= 0; i--){
            for(int j = i + 1; j < n ; j++){
                if(rack.get(i) < rack.get(j))dp[i] = Math.max(dp[i] , rack.get(i) +  dp[j]);
            }
        }
        int maxi = 0;
        for(int i = 0;i  < n; i++){
            maxi = Math.max(dp[i] , maxi);
        }
        return maxi;
    }
}
