import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[] maxMinWindow(int[] a, int n) {
        // Write your code here
        int[] ans = new int[n];
        int[] left = new int[n];
        int[] right  = new int[n];
        Stack<Integer> stack = new Stack<>();
        Arrays.fill(ans, Integer.MIN_VALUE);
        
        for(int i = 0; i < n ;i++){
            while(!stack.isEmpty() && a[stack.peek()] >= a[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                left[i] = -1;
            }else{
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = n -1; i >= 0 ;i--){
            while(!stack.isEmpty() && a[stack.peek()] >= a[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                right[i] = n;
            }else{
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        for(int i = 0; i < n ;i++){
            int len = right[i] - left[i] - 1;
            ans[len - 1] = Math.max(ans[len - 1], a[i] );
            
        }
        for(int i = n - 2; i >= 0; i--){
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }
        
        return ans;
    }
}

