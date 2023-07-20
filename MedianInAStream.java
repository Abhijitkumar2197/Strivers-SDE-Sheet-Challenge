import java.util.*;

public class Solution {
    public static int[] findMedian(int[] arr, int n) {
        int[] ans = new int[arr.length];
        PriorityQueue<Integer> hq = new PriorityQueue<>();
        PriorityQueue<Integer> lq = new PriorityQueue<>( (a,b) -> b - a);
        lq.add(arr[0]);
        ans[0] = arr[0];
        for (int i = 1; i < arr.length; i++){
            lq.add(arr[i]);
            if(lq.size() > (hq.size() + 1)){
                hq.add(lq.poll());
            }else if(hq.size() > lq.size() + 1){
                lq.add(hq.poll());
            }
            if(!lq.isEmpty() && !hq.isEmpty() && lq.peek() > hq.peek()){
                int a = hq.poll();
                hq.add(lq.poll());
                lq.add(a);
            }
            if(i % 2 != 1){
                ans[i] = (lq.size() - hq.size() > 0) ? lq.peek()  : hq.peek() ;
            }else{
                ans[i] = (lq.peek() + hq.peek())/2;
            }
        }
        return ans;
    }
}
