import java.util.*;
import java.util.List;
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

public class Solution
{
    public static Node findMiddle(Node head)
    {
        HashMap<Integer, Node> map = new HashMap<>();
        Node temp = head;
         int index = 1;
         int size = 0;

    while (temp != null) {
        size++;
        map.put(index++, temp);
        temp = temp.next;
    }
        return (size % 2 == 0) ? map.get((size + 2)/ 2) : map.get((size + 1)/2);
    }
}
