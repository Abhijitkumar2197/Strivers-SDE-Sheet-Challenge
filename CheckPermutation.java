import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean areAnagram(String str1, String str2){
        // Write your code here.
        if(str1.length() != str2.length()) return false;
        int[] ch = new int[26];
        for(int i = 0; i < str1.length(); i++){
            ch[str1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < str2.length(); i++ ){
            ch[str2.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(ch[i] != 0) return false;
        }
        return true;
     }
}
