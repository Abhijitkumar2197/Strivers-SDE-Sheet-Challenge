public class Solution {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        int[] arr = new int[2360];
        int ans = 1;
        for(int i = 0; i < at.length; i++){
            int start  = at[i];
            int end = dt[i];
            for(int j = start; j <= end; j++){
                arr[j]++;
                ans = Math.max(ans, arr[j]);
            }
        }
        return ans;
    }
}
