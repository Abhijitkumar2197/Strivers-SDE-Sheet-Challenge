import java.util.* ;
import java.io.*; 
 class Solution {
	public static int uniquePaths(int m, int n) {
		int a  = ( m - 1 ) + ( n - 1);
        double res = 1;
        for( int i = 1; i <= m - 1; i++){
            res = (res * (a - ( m - 1 ) + i) /i );        }
        return (int)res;
	}
}
