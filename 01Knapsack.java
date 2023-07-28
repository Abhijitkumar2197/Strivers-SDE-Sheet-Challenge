import java.util.*;

public class Solution {
    public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
        int[][] dp = new int[w + 1][weights.size()];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
//        for(int i = 1; i < w + 1; i ++){
//            for(int j = 0;j < weights.size(); j++ ){
//                if(i > weights.get(j)){
//                    dp[i][]
//                }
//            }
//        }
        return naphelper(values,weights,0,w,dp);
    }
	public static int naphelper(ArrayList<Integer> values, ArrayList<Integer> weights, int index, int w , int[][] dp) {
        if(w <= 0 || index >= weights.size()) return 0;
        int a = 0, b = 0;
        if(dp[w][index] != -1) return dp[w][index];
        if(weights.get(index) <= w) a = values.get(index) + naphelper(values,weights, index + 1, w - weights.get(index),dp);
        b = naphelper(values,weights,index + 1, w,dp);
        dp[w][index] = Math.max(a, b);
        return dp[w][index];
    }

    
}
