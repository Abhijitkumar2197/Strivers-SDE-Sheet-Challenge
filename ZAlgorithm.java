public class Solution {

	public static int zAlgorithm(String s, String p, int n, int m) {
		// Write your code here
		char ch[] = new char[s.length() + 1 + p.length()];
        int i = 0;
        while( i < p.length()){
            ch[i] = p.charAt(i); 
            i++;
        }
        ch[i] = '$';
        i++;
        int j = 0;
        while( j < s.length()){
            ch[i] = s.charAt(j);
            j++;
            i++;
        }
        int[] Z = calculate(ch);
        int ans = 0;
        for(int a = 0; a < ch.length; a ++){
            if(Z[a] == p.length()) ans++;
        }
        return  ans;
	}
	public static int[] calculate(char[] input){
        int[] Z = new int[input.length];
        int left = 0, right = 0;
        for (int k = 1; k < input.length; k++) {
            if (k > right) {
                left = right = k;
                while (right < input.length && input[right - left] == input[right]) {
                    right++;
                }
                Z[k] = right - left;
                right--;
            } else {
                int k1 = k - left;
                if (Z[k1] < right - k + 1) {
                    Z[k] = Z[k1];
                } else {
					left = k;
                    while (right < input.length && input[right - left] == input[right]) {
                        right++;
                    }
                    Z[k] = right - left;
                    right--;
                }
            }
        }
        return Z;
    }

}
