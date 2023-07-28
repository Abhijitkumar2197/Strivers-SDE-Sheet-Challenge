import java.util.*;
public class Solution {

	public static int lcs(String s1, String s2) {
		int a = s1.length();
        int b = s2.length();
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        for(int i = 0 ;i < a + 1 ; i++){
            dp[i][0] = 0;
        }
        for(int i = 0 ;i < b + 1 ; i++){
            dp[0][b] = 0;
        }
        for(int i = 1; i < a + 1; i++){
            for(int j = 1; j < b + 1; j++){
                dp[i][j] = f(s1,s2,i,j,dp);
            }
        }
        return dp[a][b];
    }
    public static int f(String s1, String s2,int i1,int i2 , int[][] dp){
        if(i1  == 0 || i2 == 0){
            return 0;
        }
        if(dp[i1][i2] != -1){
            return dp[i1][i2];
        }
        if(s1.charAt(i1 - 1) == s2.charAt(i2 - 1)){
            return 1 + f(s1,s2,i1 - 1,i2 - 1,dp);
        }else{
            return Math.max(f(s1,s2,i1 - 1,i2,dp),f(s1,s2,i1,i2 - 1,dp));
        }
    }

}
