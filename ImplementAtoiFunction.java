import java.util.* ;
import java.io.*; 
public class Solution {
    public static int atoi(String str) {
    int n = str.length();
    if (n == 0) return 0;

    int i = 0;
    while (i < n && str.charAt(i) == ' ') {
        i++;
    }

    str = str.substring(i);

    int sign = 1;
    int ans = 0;
    if (str.charAt(0) == '-') {
        sign = -1;
    }

    i = (str.charAt(0) == '+' || str.charAt(0) == '-') ? 1 : 0;

    while (i < n) {
        if (Character.isDigit(str.charAt(i))) {
            ans = ans * 10 + str.charAt(i) - '0';
        }
        i++;
    }
    return sign * ans;
}

}
