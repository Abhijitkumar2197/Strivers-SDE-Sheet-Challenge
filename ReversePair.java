import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

 class Solution 
{
    public static int reversePairs(ArrayList<Integer> arr) 
    {
        int[] arr1 = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            arr1[i] = arr.get(i);
        }
        mergeSort2(arr1);
        int mer = count;
        count  = 0;
        return mer;
    }


    static int count = 0;
    public static int[] mergeSort2(int[] arr){
        if(arr.length <= 1) return arr;
        int[] a = mergeSort2(Arrays.copyOfRange(arr,0,arr.length/2));
        int[] b = mergeSort2(Arrays.copyOfRange(arr,arr.length/2,arr.length));
        int[] array = new int[a.length + b.length];
        int alen = a.length;
        int blen = b.length;
        int j = 0;
        int k = 0;
        int t = 0;
        float aval = (float)a[t]/2;
        for(int i = 0; i < array.length;i++){

            if(b[j] <= a[k]){
                while ((t == 0 || t < alen) && (float)b[j] >= (float)aval) {
                    t++;
                    if(t < alen) aval = (float)a[t] /2;
                }
                count += (alen - t);
            }
            if(b[j] <= a[k]){
                array[i] = b[j++];
            }else{
                array[i] = a[k++];
            }
            if(k == alen){
                while(j < blen){
                    array[++i] = b[j++];

                }
                break;
            }
            if(j == blen){
                while(k < alen){
                    array[++i] =a[k++];
                }
                break;
            }
        }
        return array;
    }
}
