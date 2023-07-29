import java.util.*;

public class Solution {

	public static long countWaysToMakeChange(int denominations[], int value){
        long[][] dp = new long[denominations.length][value + 1];	
		for(long[] a : dp) Arrays.fill(a, -1l);		
		return countWaysHelper(denominations,dp,value,0);
	}
	public static long countWaysHelper(int deno[] , long[][] dp, int value, int index){
		if(index >= deno.length || value < 0){
			return 0;
		}		
		if(value == 0) return 1;
		if(dp[index][value] != -1) return dp[index][value];
		long count2 = countWaysHelper(deno, dp, value - deno[index], index);
		long count = countWaysHelper(deno, dp, value, index + 1);
		dp[index][value] = count + count2;
		return dp[index][value];

	}
	
}
