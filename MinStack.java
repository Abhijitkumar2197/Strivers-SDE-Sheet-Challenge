import java.util.* ;
import java.io.*; 

public class Solution {

    static class MinStack {
        Stack<Integer> stack;
        int min;
        // Constructor
        MinStack() {
            // Write your code here.
            stack = new Stack<>();
            min = Integer.MAX_VALUE;

        }

        // Function to add another element equal to num at the top of stack.
        void push(int num) {
            // Write your code here.
            if(num <= min){
                stack.push(min);
                min = num;
            }
            stack.push(num);
        }

        // Function to remove the top element of the stack.
        int pop() {
            if(stack.isEmpty()) return -1;
            // Write your code here.
            int front = stack.pop();
            if(front == min){
                min = stack.pop();
            }
            return front;
        }

        // Function to return the top element of stack if it is present. Otherwise
        // return -1.
        int top() {
            // Write your code here.
            if(stack.isEmpty()) return -1;
            return stack.peek();
        }

        // Function to return minimum element of stack if it is present. Otherwise
        // return -1.
        int getMin() {
            if(stack.isEmpty()) return -1;
            return min;
            // Write your code here.
        }
    }
}
