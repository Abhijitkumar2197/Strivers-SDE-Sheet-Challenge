import java.util.* ;
import java.io.*; 
public class Kthlargest {

    int k ;
        PriorityQueue<Integer> q ;



        Kthlargest(int k, int[] arr) {
            this.k = k;
            q = new PriorityQueue<>(k);
            for(int i = 0; i < arr.length; i++){
                add(arr[i]);
            }
        }

        void add(int num) {
            q.add(num);
            if(q.size() > k){
                q.poll();
            }
        }

        int getKthLargest() {
            return q.peek();
        }
}
