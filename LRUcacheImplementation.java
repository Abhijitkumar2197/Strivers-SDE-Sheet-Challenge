import java.util.*;

class Node{
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value= value;
    }
    
}


public class LRUCache
{
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer,Node> map = new HashMap<>();

    
    LRUCache(int capacity)
    {
        this.capacity = capacity;
    }

    public int get(int key)
    {
        if(!map.containsKey(key)) return -1;
        
        if(map.get(key) == head) return map.get(key).value;
        Node b = map.get(key);
        if(map.get(key) == tail){
            tail = tail.next;
            tail.prev = null;
            
            b.prev = head;
            head.next = b;
            head = b;
            return b.value;
        }
        b.prev.next = b.next;
        b.next.prev = b.prev;
        head.next = b;
        b.prev = head;
        head = b;
        return b.value;
        
    }

    public void put(int key, int value)
    {
        Node a = new Node(key,value);
        if(map.containsKey(key)){
            if(map.get(key) == head) {
                map.get(key).value = value;
                return;
            }
            if(map.get(key) == tail){
                head.next = a;
                a.prev = head;
                head = a;
                tail = tail.next;
                tail.prev = null;
                map.remove(key);
                map.put(key, a);
                return;
            }
            Node b = map.get(key);
            b.prev.next = b.next;
            b.next.prev = b.prev;
            head.next = a;
            a.prev = head;
            head = a;
            map.remove(key);
            map.put(key, a);
        }else{
            if(map.size() < capacity){
                if(map.size() == 0){
                    map.put(key, a);
                    head = a;
                    tail = a;
                    return;
                }
                map.put(key, a);
                head.next = a;
                a.prev = head;
                head = a;
                return;
                
            }else{
                if(capacity == 1){
                    map = new HashMap<>();
                    map.put(key,a);
                    head = a;
                    tail = a;
                    return;
                }
                map.put(key, a);
                map.remove(tail.key);
                tail =tail.next;
                tail.prev = null;
                head.next = a;
                a.prev = head;
                a.next = null;
                head = a;
                return;
                
                
            }
            
        }
    }
}
 
