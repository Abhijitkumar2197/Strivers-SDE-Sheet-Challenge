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
 };

 *****************************************************************/

 class Solution {
    public static Node rotate(Node head, int k) {
        if(head == null){
            return null;
        }
        Node temp = head;
        int size = 0 ;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        k = k % size;
        int count = 0;
        Node t = head;
        temp = head;
        while(k != size - count - 1 ){
            temp = temp.next;
            count++;
        }
        if(temp == null ){
            return head;
        }
        Node head1 = temp.next;
        Node temp1 = head1;
        while(temp1 != null && temp1.next != null){
            temp1 = temp1.next;
        }
        if(temp1 == null){
            return head;
        }
        temp1.next = head;
        temp.next = null;
        return head1;
    }
}
