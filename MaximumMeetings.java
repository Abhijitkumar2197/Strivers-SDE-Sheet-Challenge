import java.util.*;
public class Solution {
    public static int maximumMeetings(int []start, int []end) {
        int[][] arr = new int[start.length][2];
        for(int i = 0; i < arr.length; i++){
            arr[i][0] = end[i];
            arr[i][1] = start[i];
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        int ans = 1;
        int prev = arr[0][0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i][1] > prev){
                ans++;
                prev = arr[i][0];
            }
        }

        return ans;
    }
}
