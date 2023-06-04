public class Solution 
{
    public static LinkedListNode<Integer> reverseLinkedList(LinkedListNode<Integer> head) 
    {
        LinkedListNode<Integer> prev = null;
        LinkedListNode<Integer> front = null;
        LinkedListNode<Integer > curr = head;

        while(curr != null){
            LinkedListNode<Integer> l = curr.next;
             curr.next = prev;
            prev = curr;
            curr = l;

        }

        return prev;
    }
}
