import java.util.* ;
import java.io.*; 
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        // Write your code here.
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < price.size(); i++){

            while(!stack.isEmpty() && price.get(stack.peek()) <= price.get(i)){
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.push(i);
                ans.add(i + 1);
            }else{
                ans.add(i - stack.peek());
                stack.push(i);
            }
            
        }


        return ans;
    }
}
