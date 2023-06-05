import java.util.*;

class Solution {
    public static Node firstNode(Node head) {
        HashSet<Node> set = new HashSet<>();
        while(head != null && !set.contains(head)){
            set.add(head);
            head = head.next;
        }
        return head == null ? null : head;
    }
}
