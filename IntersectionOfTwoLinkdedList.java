import java.util.*;

/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;

     Node()
     {
         this.data = 0;
         this.next = null;
     }
     Node(int data)
     {
         this.data = data;
         this.next = null;
     }
     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
     }
 }

 *****************************************************************/

public class Solution {
    public static int findIntersection(Node firstHead, Node secondHead) {
        HashSet<Node> set = new HashSet<>();
        while(firstHead != null){
            set.add(firstHead);
            firstHead = firstHead.next;
        }
        if(set.contains(secondHead)) return secondHead.data;
        while(secondHead != null && !set.contains(secondHead)){
			if(secondHead.data == -1) break;
            secondHead = secondHead.next;
        }
        return (secondHead.data == -1) ? null : secondHead.data ;
    }
}
