import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minSumPath(int[][] grid) {
    int ans = 0;
        int r = grid.length;
        int c = grid[0].length;
        if(r == 1 && c ==1) return grid[0][0];
        if(r == 1 ){
            int a = 0;
            for(int i = 0 ; i < c; i++){
                a += grid[0][i];
            }
            return a;
        }
        if(c == 1 ){
            int a = 0;
            for(int i = 0 ; i < c; i++){
                a += grid[i][0];
            }
            return a;
        }
        int[][] dist = new int[r][c];
        for(int[] a : dist){
            Arrays.fill(a,Integer.MAX_VALUE);
        }
        ans = shortdis(grid,dist,0,0);
        return ans;
    }
    public static int shortdis(int[][] grid, int[][] dist, int ro , int co){
        if(ro == grid.length - 1 && co == grid[0].length - 1) return grid[ro][co];
        if(dist[ro][co] != Integer.MAX_VALUE) return dist[ro][co];
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        if(ro + 1 < grid.length) a =  grid[ro][ co] +  shortdis(grid,dist,ro + 1,co);
        if(co + 1 < grid[0].length) b = grid[ro][ co] +  shortdis(grid,dist,ro,co + 1);
        dist[ro][co] = Math.min(a,b);
        return dist[ro][co];
    }
}
