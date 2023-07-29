import java.util.* ;
import java.io.*; 

public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
        int ans = 0;
        int[][] dp = new int[N][N];
        for(int[] a : dp) Arrays.fill(a, -1);
        return matMulHelper(arr, 1, N - 1, dp);
	}
    public static int matMulHelper(int[] arr , int i, int j, int[][] dp) {
		if(i == j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i ; k < j; k++){
            min = Math.min(min , (arr[i- 1] * arr[k] * arr[j] ) + matMulHelper(arr, i, k,dp) + matMulHelper(arr, k + 1, j,dp));
        }
        dp[i][j] = min;
        return min;
	}
}
