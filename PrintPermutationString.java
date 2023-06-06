import java.util.* ;
import java.io.*; 
public class Solution {
    public static List<String> findPermutations(String s) {
        HashSet<Integer> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        permutation(s, new StringBuilder(), set, ans);
        return ans;

    }
    public static void permutation(String s, StringBuilder curr,HashSet<Integer> set, List<String> answers) {
        if(curr.length() == s.length()) {
            answers.add(new String(curr.toString()));
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(!set.contains(i)){
                curr.append(s.charAt(i));
                set.add(i);
                permutation(s, curr,set,answers);
                set.remove(i);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }
}
