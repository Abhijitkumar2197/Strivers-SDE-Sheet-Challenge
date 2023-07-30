/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node child;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.child = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.child = null;
     }
     Node(int data, Node next, Node child)
     {
         this.data = data;
         this.next = next;
         this.child = child;
     }
 }

 *****************************************************************/
import java.util.*;
public class Solution {
    public static Node flattenLinkedList(Node head) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();   
        Node curr = head;
        Node root = new Node(100);
        Node temp = root;
    while(curr != null){
        Node temp1 = curr; 
        while(temp1 != null){
            pq.add(temp1.data);
            temp1=temp1.child;
        } 
     curr=curr.next;
    }
    while(!pq.isEmpty()){
        int data = pq.poll();
       Node nn = new Node(data);
       temp.child = nn;
       temp = temp.child;
    }
    return root.child;
    }
}
