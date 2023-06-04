import java.io.*;
import java.util.* ;

import java.util.ArrayList;

 class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {
		HashMap<Long,Integer> map = new HashMap<>();
		int ans = 0;
		long prefixSum = 0;
		for(int i = 0; i < arr.size(); i++){
			prefixSum += arr.get(i);
			if(prefixSum == 0){
				ans = Math.max(ans, i + 1);
			}
			else if(map.containsKey(prefixSum)){
				ans = Math.max(ans, i - map.get(prefixSum));
			}
			if(!map.containsKey(prefixSum)) map.put(prefixSum, i);
		}
		return ans;
	}
}
