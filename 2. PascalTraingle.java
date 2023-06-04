import java.io.*;
import java.util.* ;

import java.util.ArrayList;

public class Solution {
	public static ArrayList<ArrayList<Long>> printPascal(int n) {
        ArrayList<ArrayList<Long>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(Arrays.asList(1L)));
        if(n == 1) return  ans;
        ans.add(new ArrayList<>(Arrays.asList(1L,1L)));
        if(n == 2) return ans;
        n = n -1;
        int j = 2;
        while( j <= n){
            ArrayList<Long> list = new ArrayList<>();
            for(int k = 0; k <= j ;k++){
                if(k == 0 || k == j){
                    list.add(1L);
                    continue;
                }
                Long a = ans.get(j - 1).get(k -1) + ans.get(j - 1).get(k);
                list.add(a);
            }
            ans.add(list);
            j++;
        }
        return ans;
	}
}
