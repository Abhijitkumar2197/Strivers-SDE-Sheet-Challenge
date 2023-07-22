public class Solution 
{
    public static int getTotalIslands(int[][] mat)
    {
        int count = 0;
        boolean[][] bool = new boolean[mat.length][mat[0].length];
        for(int i = 0; i  < mat.length ; i++ ){
            for(int j = 0 ; j < mat[0].length; j++){
                if(mat[i][j] != 1){
                    bool[i][j] = true;
                }
            }
        }
        for(int i = 0; i < mat.length; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                if(!bool[i][j]){
                    bool[i][j] = true;
                    fun(mat,bool,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void fun(int[][] grid, boolean[][] bool,int row , int col){
        bool[row][col] = true;
        if(row - 1 >= 0 && grid[row -1][col] == 1 && !bool[row - 1][col]){
            fun(grid,bool,row - 1,col);
        }
        if(row + 1 < grid.length && grid[row + 1][col] == 1 && !bool[row + 1][col]){
            fun(grid,bool,row + 1,col);
        }
        if(col - 1 >= 0 && grid[row ][col -1] == 1 && !bool[row][col - 1]){
            fun(grid,bool,row,col - 1);
        }
        if(col + 1 <  grid[0].length && grid[row][col + 1] == 1 && !bool[row][col + 1]){
            fun(grid,bool,row,col + 1);
        }
        if(row - 1 >= 0 && col - 1 >= 0 && grid[row -1][col - 1] == 1 && !bool[row - 1][col - 1]){    //row -1 , col -1
            fun(grid,bool,row - 1,col - 1);
        }
        if(row + 1 < grid.length && col - 1 >= 0 && grid[row + 1][col - 1] == 1 && !bool[row + 1][col - 1]){
            fun(grid,bool,row + 1,col - 1);
        }
        if(row - 1 >= 0 && col + 1 <  grid[0].length && grid[row -1][col + 1] == 1 && !bool[row - 1][col + 1]){    
            fun(grid,bool,row - 1,col + 1);
        }
        if(row + 1 < grid.length && col + 1 <  grid[0].length && grid[row + 1][col + 1] == 1 && !bool[row + 1][col + 1]){
            fun(grid,bool,row + 1,col + 1);
        }


    }
}
