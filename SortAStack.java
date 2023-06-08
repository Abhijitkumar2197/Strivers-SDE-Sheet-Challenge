import java.util.* ;
import java.io.*; 
public class Solution {
	static PriorityQueue<Integer> q = new PriorityQueue<>();
	public static void sortStack(Stack<Integer> stack) {
		reurse(stack);
	}

	public static void reurse(Stack<Integer> stack){
		if(stack.isEmpty()) return;
		q.add(stack.pop());
		reurse(stack);
		stack.push(q.poll());
	}

}
