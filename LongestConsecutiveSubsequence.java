import java.io.*;
import java.util.* ;

 class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        int ans = 1;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            set.add(arr[i]);
        }
        for(int i = 0; i  < arr.length; i++){
            int a = arr[i];
            if(!set.contains(a - 1)){
                int count = 1 ;
                int b = a;
                while(set.contains(b + 1)){
                    b = b+ 1;
                    count++;
                }
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}
