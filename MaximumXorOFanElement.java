import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> queries) {
        ArrayList<Integer>  ans = new ArrayList<>();
        for(ArrayList<Integer> i:queries){
            int till = i.get(1);
            int curr = i.get(0);
            int max = -1;
            for(int k: arr){
                if(k <= till) max=Math.max( max, curr ^ k );
            }
            ans.add(max);
        } return ans;
    }
}
