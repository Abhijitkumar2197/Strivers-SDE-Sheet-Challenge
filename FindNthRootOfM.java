public class Solution {
    public static int NthRoot(int n, int m) {
        int i =0;
        int j = m;
        while(i <= j){
            int mid = (i + j) /2;
            if(Math.pow(mid, n) == m){
                return mid;
            }else if(Math.pow(mid, n) < m){
                i = mid + 1;
            }else{
                j = mid -1;
            }
        }
        return -1;
    }
}
