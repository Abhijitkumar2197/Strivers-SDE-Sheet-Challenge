import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution {

	public static ArrayList<String> wordBreak(String s, ArrayList<String> dictionary) {
		ArrayList<String> ans = new ArrayList<>();
        wordBreakHelper(s,dictionary,new StringBuilder(),0,ans);
        return ans;
	}
	public static void wordBreakHelper(String s, ArrayList<String> dictionary , StringBuilder str, int index,ArrayList<String> ans){
        if(index == s.length()){
            ans.add(new String(str.toString()));
            return;
        }
        StringBuilder head = new StringBuilder(str);
        StringBuilder curr = new StringBuilder();
        for(int i = index; i < s.length(); i++){
            curr.append(s.charAt(i));
            if(dictionary.contains(curr.toString())){
                if(index != 0)str.append(" ");
                str.append(curr);
                wordBreakHelper(s,dictionary,str,i + 1,ans);
                str = new StringBuilder(head);
            }
        }
    }
}
