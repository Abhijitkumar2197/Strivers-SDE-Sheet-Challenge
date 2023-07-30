import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        Collections.sort(arr);
        int repeat = -1; 
        int miss = -1;
        int[] array = new int[n + 1];
        for(int i = 0; i < arr.size(); i++){
            array[arr.get(i)]++;
        }
        for(int i = 1; i < array.length; i++ ){
            if(array[i] == 0) miss = i;
            if(array[i] > 1)  repeat = i;
        }
        return new int[]{miss,repeat};
    }
} 
