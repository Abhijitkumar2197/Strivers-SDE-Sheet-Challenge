import java.util.* ;
import java.io.*; 
public class Solution {
    public static int romanToInt(String s) {
        // Write your code here
        HashMap<Character,Integer> values = new HashMap<>();
        values.put('I',1);
        values.put('V',5);
        values.put('X',10);
        values.put('L',50);
        values.put('C',100);
        values.put('D',500);
        values.put('M',1000);
                
        int sum = 0;
        int prev = Integer.MAX_VALUE;
        for(int i = 0; i < s.length(); i++){
            int currvalue = values.get(s.charAt(i));
            sum += currvalue;
            if(currvalue > prev){
                sum -= (2 * prev);
            }
            prev = currvalue;
            
        }
        return sum;
    }
}
