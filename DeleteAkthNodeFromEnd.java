import java.util.*;

/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node next;
     public Node prev;

     Node()
     {
         this.data = 0;
         this.next = null;
         this.prev = null;
     }

     Node(int data)
     {
         this.data = data;
         this.next = null;
         this.prev = null;
     }

     Node(int data, Node next)
     {
         this.data = data;
         this.next = next;
         this.prev = next;
     }
 };

 *****************************************************************/

public class Solution
{
    public static Node removeKthNode(Node head, int K)
    {
        if(head.next == null){
            return null;
        }
        Node ans = head;
        ArrayList<Node> list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head = head.next;
        }
        {
            if(K == list.size()){
                return ans.next;
            }
            Node temp = list.get(list.size() - K);

            Node temp1 = list.get(list.size() - K - 1);
            temp1.next = temp.next;
        }
        return ans;
    }
}
