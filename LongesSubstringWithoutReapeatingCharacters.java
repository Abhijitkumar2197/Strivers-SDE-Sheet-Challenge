import java.util.* ;
import java.io.*; 
public class Solution 
{
	public static int uniqueSubstrings(String input) 
    {
		int ans = 0;
        String str = "";
        for(int i = 0; i < input.length();i++){
            if(str.contains(input.charAt(i) + "")){
                int a = str.indexOf(input.charAt(i));
                str = str.substring(a+1);
                str = str + input.charAt(i) ;
            }else{
                str = str + input.charAt(i) ;
                ans = Math.max(ans,str.length());
            }
        }
        return ans;
	}
}
