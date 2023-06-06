import java.util.*;
import java.io.*;

public class Solution {
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        ArrayList<ArrayList<String>> answer = new ArrayList<>();
        boolean[][] bool = new boolean[n][n];
        NQueens(n, bool,answer,0);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < answer.size(); i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j < answer.get(i).size(); j++){
                for(int k = 0; k < answer.get(i).get(j).length(); k++){
                    if(answer.get(i).get(j).charAt(k) == 'Q'){
                        temp.add(1);
                    }else{
                        temp.add(0);
                    }
                }
            }
            ans.add(temp);
        }
        return ans;
    }
    public static boolean boxCheck(boolean[][] arr, int row , int col){
        boolean check = true;
        for(int i = 0 ; i < arr.length; i++){

            if(arr[row][i]){
                return false;
            }
            if(arr[i][col]){
                return false;
            }
        }
        int i = row;
        int j = col;
        while(i >= 0 && j >=0){
            if(arr[i][j]) return false;
            i--; j--;
        }
        i = row;
        j = col;
        while(i >= 0 && j < arr.length){
            if(arr[i][j]) return false;
            i--; j++;
        }

        i = row;
        j = col;
        while(i < arr.length && j < arr.length){
            if(arr[i][j]) return false;
            i++; j++;
        }
        i = row;
        j = col;
        while(i < arr.length && j >= 0){
            if(arr[i][j]) return false;
            i++; j--;
        }
        return check;
    }
    public static void NQueens(int count , boolean[][] bool,ArrayList<ArrayList<String>> answer,int row){
        if(count == 0){
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < bool.length; i++){
                String str = "";
                for(int j = 0; j < bool.length; j++){
                    if(bool[i][j]){
                        str += "Q";
                    }else{
                        str += ".";
                    }
                }
                list.add(str);
            }
            answer.add(list);
            return;
        }
        if(bool.length - row != count) return;
        if(row == bool.length){
            return;
        }

        for(int j = 0; j < bool.length; j++){
            if(boxCheck(bool,row,j)){
                bool[row][j] = true;
                NQueens(count - 1,bool,answer,row + 1);
                bool[row][j] = false;
            }
        }
    }
}
