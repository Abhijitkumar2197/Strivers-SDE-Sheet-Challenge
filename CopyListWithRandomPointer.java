import java.io.*;
import java.util.* ;

/*************************************************************

    Following is the LinkedListNode class structure

    class LinkedListNode<T> {
	    T data;
	    LinkedListNode<T> next;
	    LinkedListNode<T> random;

	    public LinkedListNode(T data) {
		    this.data = data;
	    }
    }

*************************************************************/

public class Solution {
	 static LinkedListNode<Integer> cloneRandomList(LinkedListNode<Integer> head) {
		if(head == null){
            return null;
        }
        LinkedListNode<Integer> node = new LinkedListNode<Integer>(0);
        LinkedListNode<Integer> head2 = node;
        node.data = head.data;
        LinkedListNode<Integer> temp = head;
        temp = temp.next;
        while(temp != null){
            LinkedListNode<Integer> node1 = new LinkedListNode<Integer>(temp.data);
            node.next = node1;
            node = node.next;
            temp = temp.next;
        }
        temp = head;
        LinkedListNode<Integer> temp2 = head2;
        while(temp != null){
            if(temp.random == null){
                temp2.random = null;

            }else{
                LinkedListNode<Integer> temp3 = head;
                LinkedListNode<Integer> temp4 = head2;
                while(temp3 != null){
                    if(temp3 == temp.random){
                        temp2.random = temp4;
                        break;
                    }
                    temp3 = temp3.next;
                    temp4 = temp4.next;
                }
            }
            temp = temp.next;
            temp2 = temp2.next;
        }
        return head2;
	}
}
