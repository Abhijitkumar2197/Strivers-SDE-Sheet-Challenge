import java.util.* ;
import java.io.*; 
public class Solution {

	public static int[] KMostFrequent(int n, int k, int[] arr) {
		HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            if(map.get(a) != map.get(b)){
                return map.get(b) - map.get(a);
            }else{
                return Integer.compare(a,b);
            }
        });
        for(int a : map.keySet()){
            pq.offer(a);
        }
        int[] ans = new int[k];
        int i = 0;
        while(!pq.isEmpty() && k > 0){
            ans[i++] = pq.poll();
			k--;
        }
        return ans;

		
	}

}
