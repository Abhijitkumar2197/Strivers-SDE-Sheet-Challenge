import java.util.*;
public class Solution {
	public static String longestCommonPrefix(String[] arr, int n) {
		// Write your code here
		StringBuilder ans = new StringBuilder();
		for(int i = 0; i < arr[0].length(); i++){
			char ch = arr[0].charAt(i);
			boolean check = true;;
			for(int j = 0; j < arr.length; j++){
				if(ch != arr[j].charAt(i)){
					check = false;
					break;
				}
			}
			if(check){
				ans.append(ch);
			}else{
				break;
			}
		}
		return ans.toString();
	}

}
