import java.util.* ;
import java.io.*; 

public class Solution {
	
	public static int[] nextGreater(int[] arr, int n) {	
		int numlen = arr.length;
        int[] answer = new int[numlen];

        Stack<Integer> stack = new Stack<>();
        for(int i  = n - 1; i >= 0 ; i-- ){

            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.push(arr[i]);
                answer[i % numlen] = -1;
            }else{
                answer[i % numlen] = stack.peek();
                stack.push(arr[i]);
            }

        }

        return answer;
		
	}

}
