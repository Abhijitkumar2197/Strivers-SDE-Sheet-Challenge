import java.util.* ;
import java.io.*; 
]class Solution {
    static long count = 0;
    public static long getInversions(long arr[], int n) {
        long mer = 0;
        mergeSort(arr);
        mer = count;
        count = 0;

        return mer;
    }


    public static long[] mergeSort(long[] arr){
        if(arr.length <= 1) return arr;
        long[] a = mergeSort(Arrays.copyOfRange(arr,0,arr.length/2));
        long[] b = mergeSort(Arrays.copyOfRange(arr,arr.length/2,arr.length));
        long[] array = new long[a.length + b.length];
        int alen = a.length;
        int blen = b.length;
        int j = 0;
        int k = 0;
        for(int i = 0; i < array.length;i++){
            if(b[j] < a[k]){
                array[i] = b[j++];
                count += (alen - k );
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
//                    count += alen;
                }
                break;
            }
        }
        return array;
    }
}
