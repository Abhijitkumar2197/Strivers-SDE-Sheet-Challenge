import java.util.* ;
import java.io.*; 
public class Queue {
    ArrayList<Integer> list;
    Queue() {
        // Implement the Constructor
        list  = new ArrayList<>();

    }

    /*----------------- Public Functions of Queue -----------------*/

    boolean isEmpty() {
        // Implement the isEmpty() function
        return list.size() == 0;
    }

    void enqueue(int data) {
        // Implement the enqueue() function
        list.add(data);
    }

    int dequeue() {
        if(list.isEmpty()) return -1;
        // Implement the dequeue() function
        return list.remove(0);
    }

    int front() {
        // Implement the front() function
        if(list.isEmpty()) return -1;
        return list.get(0);
    }

}
