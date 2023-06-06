
import java.util.ArrayList;
import java.util.*;
import java.util.PriorityQueue;

public class Solution {

	public static void findMedian(int arr[])  {
        
        
        List<Integer> list = new ArrayList<>();
    	for (int i = 0; i < arr.length; i++) {
        int index = Collections.binarySearch(list, arr[i]);
        if (index < 0) {
            list.add(-index - 1, arr[i]);
        } else {
            list.add(index, arr[i]);
        }

        int medianIndex = list.size() / 2;
        if (list.size() % 2 != 0) {
            System.out.print(list.get(medianIndex) + " ");
        } else {
            int median = (list.get(medianIndex) + list.get(medianIndex - 1)) / 2;
            System.out.print(median + " ");
        }
    }
    
    }


}
