import java.util.*;

public class Solution {

	public static int minTimeToRot(int[][] grid, int n, int m) {
		// Write your code here.
		int time  = 0;
        int a = grid.length;
        int b = grid[0].length;
        boolean[][] vis = new boolean[a][b];
        Queue<int[]> list = new LinkedList<>();
        int blank = 0;
        int have = 0;
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b ; j++){
                if(grid[i][j] == 0) blank++;
                if(grid[i][j] == 1) have ++;
                if(grid[i][j] == 2){
                    list.add(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        if(list.size() == 0){
            if(have == 0) return 0;
            return -1;
        }
        while(list.size() != 0){
            int lensize = list.size();
            for(int i = 0; i <lensize; i++){
                int[] arr = list.poll();
                if(arr[0] - 1 >= 0 && !vis[arr[0] - 1][arr[1]] && grid[arr[0] - 1][arr[1]] != 0){
                    list.add(new int[]{arr[0] - 1,arr[1]});
                    vis[arr[0] - 1][arr[1]] = true;
                }
                if(arr[0] + 1 < a && !vis[arr[0] + 1][arr[1]] && grid[arr[0] + 1][arr[1]] != 0){
                    list.add(new int[]{arr[0] + 1,arr[1]});
                    vis[arr[0] + 1][arr[1]] = true;
                }
                if(arr[1] - 1 >= 0 && !vis[arr[0]][arr[1] - 1] && grid[arr[0]][arr[1] - 1] != 0){
                    list.add(new int[]{arr[0],arr[1] - 1});
                    vis[arr[0]][arr[1] - 1] = true;
                }
                if(arr[1] + 1 < b && !vis[arr[0]][arr[1] + 1] && grid[arr[0]][arr[1] + 1] != 0){
                    list.add(new int[]{arr[0],arr[1] + 1});
                    vis[arr[0]][arr[1] + 1] = true;
                }
            }
            time++;
        }
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b ; j++){
                if(!vis[i][j] && grid[i][j] != 0){
                    return -1;
                }
            }
        }
        return time - 1;
	}

}
