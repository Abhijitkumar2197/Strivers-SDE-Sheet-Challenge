import java.util.* ;
import java.io.*; 
public class Solution {
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        partitionHelper(0,s,ans,new ArrayList<>());
        return ans;
    }
    public static void partitionHelper(int index, String s ,List<List<String>> ans, List<String> temp){
        if(index == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index + 1; i <= s.length(); i++){
            if(isPalindrome(s.substring(index,i))){
                temp.add(s.substring(index,i));
                partitionHelper(i,s,ans,temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
    public static boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
