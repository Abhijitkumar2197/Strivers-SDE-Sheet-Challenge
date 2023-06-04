import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static void sort012(int[] arr)
    {
        int i= 0, k = 0, j = arr.length - 1;
        while(i <= j){
            if(arr[i] == 0){
                if(k < i){
                    swap(arr,k,i);
                    k++;
                }else {
                    i++;
                    k++;
                }
            }else if(arr[i] == 2){
                swap(arr,i,j);
                j--;
            }else {
                i++;
            }
        }
        
        
    }
    public static void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
