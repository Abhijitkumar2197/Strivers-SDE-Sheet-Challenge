import java.util.*;

class Node{
		int key;
		int value;
		int freq;
		int min; 
		

		Node(int key, int value){
			this.key = key;
			this.value = value;
			this.freq = 1;
			this.min = 1;
		}
	}
	public class LFUCache {
		int capacity;
		int max;
		HashMap<Integer, Node> map;
		HashMap<Integer,LinkedList<Node>> listSet; 

		LFUCache(int capacity) {
			// Write your code here.
	    this.capacity = capacity;
	    listSet = new HashMap();
	    map = new HashMap();
	    max = 1;


		}

		int get(int key) {
			if(!map.containsKey(key)){
				return -1;
			}
			int index = map.get(key).freq;
			listSet.get(map.get(key).freq).remove(map.get(key));
			map.get(key).freq++;
			max = Math.max(max, map.get(key).freq);
			listSet.computeIfAbsent(map.get(key).freq, k -> new LinkedList()).add(map.get(key));
			// Write your code here.
			return map.get(key).value;
		}
		
		 void removeHelper() {
			for(int i = 1; i <= max; i++) {
				if(listSet.containsKey(i)) {
					map.remove(listSet.get(i).getFirst().key);
					listSet.get(i).removeFirst();
					return;
				}
			}
		}

		void put(int key, int value) {
			if(map.size() < capacity) {
				if(map.containsKey(key)) {
					listSet.get(map.get(key).freq).remove(map.get(key));
					map.get(key).freq++;
					map.get(key).value = value;
					max = Math.max(max, map.get(key).freq);
					listSet.computeIfAbsent(map.get(key).freq, k -> new LinkedList()).add(map.get(key));
					return;
				}else {
					Node a = new Node(key,value);
					map.put(key, a);
					max = Math.max(max, map.get(key).freq);
					listSet.computeIfAbsent(1, k -> new LinkedList()).add(a);
					return;
				}
			}else {
				if(map.containsKey(key)) {
					map.get(key).value = value;
					listSet.get(map.get(key).freq).remove(map.get(key));
					map.get(key).freq++;
					map.get(key).value = value;
					max = Math.max(max, map.get(key).freq);
					listSet.computeIfAbsent(map.get(key).freq, k -> new LinkedList()).add(map.get(key));
					return;
				}else {
					removeHelper();
					Node a = new Node(key,value);
					map.put(key, a);
					listSet.computeIfAbsent(1, k -> new LinkedList()).add(a);
					return;
				}
				
			}
			// Write your code here.
		}
	}
