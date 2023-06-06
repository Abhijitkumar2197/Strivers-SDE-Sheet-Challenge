public class Solution {
    public static int search(int arr[], int key) {
        int ans = pivot(arr);
        int answer;
        if (ans == -1){
            answer = index(arr,key,0 ,arr.length-1);
            return answer;
        }else{
            if(arr[ans]==key){
                return ans;
            }else if (arr[0]<=key){
                answer = index(arr,key,0 ,ans-1);
                return answer;
            }else {
                answer = index(arr,key,ans+1 ,arr.length-1);
                return answer;
            }
        }
    }
     public static int pivot(int[] arr) {
        int start = 0 , end = arr.length -1;
        while(start<=end){
            int mid = start +(end-start)/2;
            if(mid<arr.length-1 && arr[mid]>arr[mid+1]){
                return mid;
            } else if (mid>0 && arr[mid] < arr[mid-1]) {
                return mid-1;
            }else if (arr[start]>arr[mid]){
                end= mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
   public static int index(int[] arr, int key , int start ,int end){

        while(start<=end){
            int mid = start + (end -start)/2;
            if(key==arr[mid]){
                return mid;
            }else if (key>arr[mid]){
                start= mid+1;
            }else {
                end = mid-1;
            }

        }
        return -1;

    }
}
