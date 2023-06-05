import java.util.* ;

import java.io.*; 
 class Solution {
    public static long getTrappedWater(long[] arr, int n) {
        long[] lb = new long[arr.length];
        long[] rb = new long[arr.length];
        long bound = 0;
        for(int i = 0; i < arr.length; i++){
            lb[i] = bound;
            bound = Math.max(bound,arr[i]);
        }
        bound = 0;
        for(int j = arr.length - 1; j >= 0; j--){
            rb[j] = bound;
            bound = Math.max(bound, arr[j]);
        }
        long volumeOfWater = 0;
        for(int i = 0; i < arr.length; i++){
            long curr = Math.min(lb[i],rb[i]) - arr[i];
            if(curr < 0) curr=0;
            volumeOfWater = volumeOfWater + curr;
        }
        return volumeOfWater;
    }
}
