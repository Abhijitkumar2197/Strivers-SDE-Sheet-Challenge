import java.util.ArrayList;

public class Solution {
	public static ArrayList<Integer> stringMatch(String str, String pat) {
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 0; i <= str.length() - pat.length(); i++){
			if(str.substring(i, i + pat.length()).equals(pat)){
				ans.add(i);
			}
		}
		return ans;
	}
}
