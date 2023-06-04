import java.io.*;
import java.util.* ;

/************************************************************

    Following is the linked list node structure:
    
    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;

        public LinkedListNode(T data) {
            this.data = data;
        }
    }

************************************************************/

public class Solution {
	public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
		if(first == null && second == null){
            return null;
        }else if(first == null){
            return second;
        }else if(second == null){
            return first;
        }
        LinkedListNode<Integer>  node = null;
        LinkedListNode<Integer>  head = null;
        while(first != null && second != null){
            if(first.data <= second.data){
                if(node == null){
                    node = first;
                    head = node;
                    first = first.next;
                }else{
                    node.next = first;
                    node = node.next;
                    first = first.next;
                }
            }
            else {
                if(node == null){
                    node = second;
                    head = node;
                    second = second.next;
                }else{
                    node.next = second;
                    node = node.next;
                    second = second.next;
                }
            }
        }
        if(first != null){
            node.next = first;
        }else if(second != null){
            node.next = second;
        }
        return head;
	}
}
