import java.io.*;
import java.util.* ;

import java.util.ArrayList;

 class Solution {
	public static int subarraysXor(ArrayList<Integer> arr, int x) {
		int ans = 0;
        HashMap<Integer,Integer> map = new HashMap();
        map.put(0, 1);
        int a = 0;
        for(int i = 0; i < arr.size(); i++){
            a ^= arr.get(i);
            if(map.containsKey(a ^ x)){
                ans += map.get(a ^ x);
            }
			map.put(a,map.getOrDefault(a,0) + 1);
        }
        return ans;
	}
}
