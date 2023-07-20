import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
		ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer , Integer> set = new HashMap<>();
        for(int i = 0; i < k ; i++){
            set.put(arr.get(i) , set.getOrDefault(arr.get(i) , 0) + 1);
        }
        list.add(set.size());
        for(int i = k , j = 0; i < arr.size(); i++,j++){
            set.put(arr.get(j) , set.get(arr.get(j)) - 1);
            if(set.get(arr.get(j)) == 0) set.remove(arr.get(j));
            set.put(arr.get(i) , set.getOrDefault(arr.get(i) , 0) + 1);
            list.add(set.size());
        }
        return list;
	}
}
