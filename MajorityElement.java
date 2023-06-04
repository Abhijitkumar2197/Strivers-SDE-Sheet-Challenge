import java.io.*;
import java.util.* ;

 class Solution {
	public static int findMajority(int[] arr, int n) {
		int ans = -1;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i< arr.length; i++){
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
			if(map.get(arr[i]) > arr.length / 2){
				ans = arr[i];
				break;
			}
		}
		return ans;
	}
	
}
