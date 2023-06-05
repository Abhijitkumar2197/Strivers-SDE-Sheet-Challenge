import java.io.*;
import java.util.* ;

/****************************************************************

    Following is the class structure of the LinkedListNode class:

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
        LinkedListNode(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

*****************************************************************/

 class Solution {
	public static void deleteNode(LinkedListNode<Integer> node) {
		LinkedListNode<Integer> nextNode = node.next;
        node.data = nextNode.data;
        node.next = nextNode.next;
	}
}
