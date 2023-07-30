import java.util.Arrays;

public class Solution {
	public static int cutRod(int price[], int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return helper(price, dp, n);
	}
	public static int helper(int[] price , int[] dp , int n){
		if(n == 0) return 0;
		int min = 0;
		if(dp[n] != -1) return dp[n];
		for(int i = 0; i < price.length; i++){
			if(n >= i + 1){
				min = Math.max(min, price[i] + helper(price, dp, n - i -1));
			}
		}
		dp[n] = min;
		return dp[n];
	}
}
