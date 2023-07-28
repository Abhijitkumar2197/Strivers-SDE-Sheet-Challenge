import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {
	public static int maximumProduct(ArrayList<Integer> arr, int n) {
		if(n == 1) return arr.get(0);
        int a = arr.get(0);
        int maxi = arr.get(0);
        int mini = arr.get(0);
        int ans = a;
        for(int i = 1; i < n; i++){
            int min = Math.min(arr.get(i),Math.min(maxi * arr.get(i), mini * arr.get(i)));
            int max = Math.max(arr.get(i),Math.max(maxi * arr.get(i) , mini * arr.get(i)));
            maxi = Math.max(min,max);
            mini = Math.min(min , max);
            ans = Math.max(ans, maxi);
            if(arr.get(i) == 0){
                maxi = 1;
                mini = 1;
            }

        }
        return ans;
	}
}
