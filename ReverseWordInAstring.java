public class Solution 
{
	public static String reverseString(String str) 
	{
		//Write your code here
		String ans = "";
        for(int i = 0 ; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                continue;
            }
            String a = "";
            int n = i;
            while(n < str.length() && str.charAt(n) != ' '){
                a += str.charAt(n);
                n++;
            }
            i = n ;
            ans = a + " " + ans;

        }

        // ans = ans.trim(); // Remove trailing and leading whitespaces
        if (!ans.isEmpty()) {
            ans = ans.substring(0, ans.length() - 1);
        }
        return ans;
	}
}
