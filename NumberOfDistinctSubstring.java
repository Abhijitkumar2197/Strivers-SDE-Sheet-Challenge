import java.util.* ;
import java.io.*; 
public class Solution {
    public static int distinctSubstring(String word) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                String subString = word.substring(i, j + 1);
                map.put(subString, map.getOrDefault(subString, 0) + 1);
            }
        }

        return map.size();
    }
}
