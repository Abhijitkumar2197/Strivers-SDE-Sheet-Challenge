import java.io.*;
import java.util.* ;

/****************************************************************

    Following is the class structure of the Node class:

        class Node
        {
        public:
	        int data;
	        Node *next;
	        Node(int data)
	        {
		        this->data = data;
		        this->next = NULL;
	        }
        };

*****************************************************************/

public class Solution {
	public static Node getListAfterReverseOperation(Node head, int n, int b[]) {
         if(head==null) return null;
        Node node=head;
        Node curr = node;
        Node  a=null;
        boolean flag=true;
        Node nfirst=node;
        for(int len:b){
            if(curr==null)break;
            if(len<1)continue;
            Node prev = null;
            Node next = null;
            Node last=null;
            while (curr != null&&len-->0) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                last=curr;
                curr = next;
            }
            node=prev;
            while( a!=null&& a.next!=null) a= a.next;
            if( a!=null) a.next=prev;
             a=last;
            if(flag){nfirst=node;flag=false;}       
        }
        if(curr!=null){
            while( a!=null&& a.next!=null) a= a.next;
            if( a!=null) a.next=curr;
        }
        return nfirst;
    }
}
