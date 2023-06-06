import java.util.ArrayList;

public class Solution {
    public static String kthPermutation(int n, int k) {
        StringBuilder myNum = new StringBuilder();
    k--;
    int facto = 1;
    for (int i = 1; i <= n; i++) {
        myNum.append(i);
        facto *= i;
    }

    StringBuilder result = new StringBuilder();
    while (n > 0) {
        facto /= n;
        int index = k / facto;
        result.append(myNum.charAt(index));
        myNum.deleteCharAt(index);
        k %= facto;
        n--;
    }

    return result.toString();
    }
}
