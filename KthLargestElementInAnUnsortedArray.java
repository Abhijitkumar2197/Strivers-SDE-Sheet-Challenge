import java.util.* ;
import java.io.*; 
public class Solution {

	static int kthLargest(ArrayList<Integer> arr, int size, int K) {
		PriorityQueue<Integer> q = new PriorityQueue<>( );
        for(int i = 0; i  < arr.size(); i++){
            q.add(arr.get(i));
            if(q.size() > K) q.poll();
        }
        return q.peek();
	}
}
