import java.util.*;

public class Solution {
  public static int largestRectangle(ArrayList < Integer > heights) {
    int max = 0;
        int[] rb = new int[heights.size()];
        int[] lb = new int[heights.size()];
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        lb[0] = -1;
        for(int i = 1; i  < heights.size() ; i++){
            while(!stack.isEmpty() && heights.get(stack.peek()) >= heights.get(i)){
                stack.pop();
            }
            if(stack.isEmpty()){
                lb[i] = -1;
            }else{
                lb[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        stack.add(heights.size() - 1);
        rb[heights.size() - 1] = heights.size();
        for(int i = heights.size() - 2; i >= 0 ; i--){
            while(!stack.isEmpty() && heights.get(stack.peek()) >= heights.get(i)){
                stack.pop();
            }
            if(stack.isEmpty()){
                rb[i] = heights.size();
            }else{
                rb[i] = stack.peek();
            }
            stack.add(i);
        }
        for(int  i = 0; i < heights.size() ; i++){
            max = Math.max(max,heights.get(i) * (rb[i] - lb[i] - 1));
        }
        return max;
  }
}
