import java.io.*;
import java.util.* ;

 class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        int i = 0;
        int j = 0;
        int[] ans = new int[m + n];
        int k = 0;
        while(k < m + n && i < m && j < n){
            if(arr1[i] <= arr2[j]){
                ans[k++] = arr1[i]; 
                i++;
            }else{
                ans[k++] = arr2[j];
                j++;
            }
        }
        if(i < m){
            while(i < m){
                ans[k++] = arr1[i++];
            }
        }
        while(j < n){
            ans[k++] = arr2[j++];
        }
        return ans;
    }
}
