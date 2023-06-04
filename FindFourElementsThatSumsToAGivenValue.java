import java.io.*;
import java.util.* ;

 class Solution {
  public static String fourSum(int[] arr, int target, int n) {
      Arrays.sort(arr);
        if(arr[0] >  0 && target < 0){
            return "No";
        }
        ArrayList<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length ; j++){
                long sum = Long.sum(arr[i] , arr[j]);
                int k = j + 1 , l = arr.length - 1;
                long wanted = target - sum;
                while(k < l){
                    if( Long.sum(arr[k] ,arr[l])  == wanted){
                        return "Yes";
                    } else if (Long.sum(arr[k] ,arr[l])  < wanted) {
                        k++;
                    }else{
                        l--;
                    }
                }
                while(j + 1  < arr.length && arr[j + 1] == arr[j] ) j++;
            }
            while(i + 1  < arr.length && arr[i + 1] == arr[i] ) i++;

        }
        return "No";
  }
}
