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

public class Solution {
    public static Node flattenLinkedList(Node head) {
        if(head==null|| head.next==null)return head;
        Node n=flattenLinkedList(head.next);
        return helper(head,n);
    }

    static Node helper(Node n1,Node n2){
        if(n1==null)return n2;
        if(n2==null)return n2;
        Node temp=new Node(0);
        Node res=temp;
        while(n1!=null && n2!=null){
            if(n1.data<n2.data){
            temp.child=n1;
            temp=temp.child;
            n1=n1.child;
        }
        else{
            temp.child=n2;
            temp=temp.child;
            n2=n2.child;
        }
        }
        if(n1!=null) temp.child=n1;
        else temp.child=n2;
        return res.child;

}
}
