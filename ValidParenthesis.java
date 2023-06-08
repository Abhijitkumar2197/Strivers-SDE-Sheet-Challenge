import java.util.*;

public class Solution {
    public static boolean isValidParenthesis(String expression) {
        HashMap<Character,Character> map = new HashMap<>();
        map.put('[',']');
        map.put('(',')');
        map.put('{','}');
        Stack<Character> st = new Stack<>() ;
        for(int i = 0; i < expression.length(); i++){
            char ch = expression.charAt(i);
            if(!st.isEmpty() && ch == map.get(st.peek())){
                if(st.size() == 0) return false;
                st.pop();
            }else if(ch == '[' || ch == '(' || ch == '{'){
                st.push(ch);
            }else{
                return false;
            }
        }

        return st.size() == 0;
    }
}
