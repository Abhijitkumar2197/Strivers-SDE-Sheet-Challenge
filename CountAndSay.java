import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static String writeAsYouSpeak(int n)
    {
        if(n==1) return "1";
        StringBuilder str = new StringBuilder("");
        return helper(new StringBuilder("1"), n -1).toString();
    }

    public static StringBuilder helper(StringBuilder str , int n){
        if(n == 0) {
            return str;
        }
        StringBuilder next = new StringBuilder("");
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            int a = Character.getNumericValue(ch);
            int count = 1;
            int j = i + 1;
            while(j < str.length() && ch == str.charAt(j) ){
                j++;
                count++;
            }
            next.append(count);
            next.append(a);
            i = j - 1;
        }

        return helper(next, n - 1);
    }
}
