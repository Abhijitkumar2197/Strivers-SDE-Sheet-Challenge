import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the LinkedListNode class:
	
	class LinkedListNode<T> {
    	T data;
    	LinkedListNode<T> next;

    	public LinkedListNode(T data) {
        	this.data = data;
    	}
	}

*****************************************************************/

 class Solution {

	public static boolean isPalindrome(LinkedListNode<Integer> head) {
		ArrayList<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.data);
            head = head.next;
        }
        int i = 0 , j = list.size() -1;
        while(i <= j){
            if(!list.get(i).equals(list.get(j))){
                return false;
            }
            i++;
            j--;
        }
        return true;
	}
}
