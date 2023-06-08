import java.util.* ;
import java.io.*; 

import java.util.ArrayList;

public class Solution 
{

	public static ArrayList<Integer> getMaximumOfSubarrays(ArrayList<Integer> nums, int k) 
	{
		ArrayList<Integer> ans = new ArrayList<>();
    Deque<int[]> deque = new ArrayDeque<>();
    int t = 0;
    for (int i = 0; i < nums.size(); i++) {
        if (deque.isEmpty()) {
            deque.addFirst(new int[]{nums.get(i), i});
        } else if (deque.getFirst()[0] <= nums.get(i)) {
            deque = new ArrayDeque<>();
            deque.add(new int[]{nums.get(i), i});
        } else {
            while (!deque.isEmpty() && deque.getLast()[0] < nums.get(i)) {
                deque.removeLast();
            }
            deque.addLast(new int[]{nums.get(i), i});
        }
        if (deque.getFirst()[1] <= i - k) {
            deque.removeFirst();
        }
        if (i - k + 1 >= 0) {
            ans.add(t, deque.getFirst()[0]);
            t++;
        }
    }
    return ans;
}







	}
