import java.util.*;
public class Solution {

    public static int editDistance(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return minDistancehelper(new StringBuilder(str1),new StringBuilder(str2),0,0,0, dp);
    }
    public static int minDistancehelper(StringBuilder w1, StringBuilder w2, int i1, int i2, int count, int[][] dp){

        if(i1 >= w1.length()) return count + (w2.length() - i2);
        if(i2 >= w2.length()) return count + (w1.length() - i1);
        if(dp[i1][i2] != -1) return dp[i1][i2] + count;
        int a = Integer.MAX_VALUE , b = Integer.MAX_VALUE, c = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
        if(w1.charAt(i1) == w2.charAt(i2)){
            a = minDistancehelper(w1,w2,i1 + 1, i2 + 1, count,dp);
        }else{
            // insert replace delete
            b = minDistancehelper(w1 ,w2, i1, i2 + 1,count + 1,dp);
            c = minDistancehelper(w1,w2,i1 + 1,i2 + 1,count + 1,dp);
            d = minDistancehelper(w1,w2,i1 + 1,i2,count+ 1,dp);
        }
        int ans = Math.min(Math.min(a,b),Math.min(c,d));
        dp[i1][i2] = ans - count;
        return dp[i1][i2] + count;
    }
}
