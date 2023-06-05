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
 class Solution {

    public static boolean detectCycle(Node head) {
        Node slow = head;
        Node fast = head.next;
        while(fast != null){
            if(fast.next == null){
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;



    }
}
