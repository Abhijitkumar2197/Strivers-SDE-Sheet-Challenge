import java.util.* ;
import java.io.*; 
public class Stack {
    Queue<Integer> q1;
    Queue<Integer>  q2;
    int length;
    // Define the data members.


    public Stack() {
        q1 = new LinkedList<>(); 
        q2  = new LinkedList<>();
        length = 0;
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        // Implement the getSize() function.
        return q1.size();
    }

    public boolean isEmpty() {
        // Implement the isEmpty() function.
        return q1.size() == 0;
    }

    public void push(int element) {
        // Implement the push(element) function.
        q2.add(element);
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        Queue<Integer> temp = q2;
        q2 = q1;
        q1 = temp;

    }

    public int pop() {
        // Implement the pop() function.
        if(q1.isEmpty()) return -1;
        return q1.poll();
    }

    public int top() {
        if(q1.size() == 0) return -1;
        return q1.peek();   }
}
