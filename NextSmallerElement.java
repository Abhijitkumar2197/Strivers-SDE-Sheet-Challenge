import java.util.*;
import java.io.*;

public class Solution{
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n){
        // Write your code here.
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = arr.size() - 1; i >= 0; i--){

            while(!stack.isEmpty() && stack.peek() >= arr.get(i)){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans.add(0,-1);
            }else{
                ans.add(0,stack.peek());
            }
            stack.push(arr.get(i));



        }

        return ans;
    }
}
