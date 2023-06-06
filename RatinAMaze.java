import java.util.* ;
import java.io.*; 
public class Solution {
    public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
        boolean[][] bool = new boolean[maze.length][maze[0].length];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> start = new ArrayList<>();
        for(int i = 0; i < (n*n) ; i++){
            start.add(0);
        }
        ratInAMazeHelper(bool,maze,0,0,ans,start);
        return ans;
    }
    public static void ratInAMazeHelper(boolean[][] bool , int[][] maze , int r, int c,ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> list){
        if(r < 0 || c < 0 || r >= maze.length || c >= maze[0].length || bool[r][c] || maze[r][c] == 0) return;
        list.set( (r * maze.length) + (c % maze[0].length) , 1);
        bool[r][c] = true;
        if(r == maze.length - 1 && c == maze[0].length - 1){
            ans.add(new ArrayList<>(list));
            list.set( (r * maze.length) + (c % maze[0].length) , 0);
            bool[r][c] = false;
            return;
        }
        ratInAMazeHelper(bool,maze , r + 1, c, ans,list);
        ratInAMazeHelper(bool,maze , r , c + 1, ans,list);
        ratInAMazeHelper(bool,maze , r - 1, c, ans,list);

        ratInAMazeHelper(bool,maze , r, c - 1, ans,list);

        list.set((r * maze.length) + (c % maze[0].length) , 0);
        bool[r][c] = false;

    }
}
