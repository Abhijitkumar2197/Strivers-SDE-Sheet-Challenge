import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
	public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
		int ans = 0;
        int currCount = 0;
        int canChange = k;
        LinkedList<Integer> list = new LinkedList();
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) == 1){
                currCount++;
            }else if( canChange > 0){
                currCount++;
                list.add(i);
                canChange--;
            }else if( canChange <= 0 && list.size() != 0 ){
                ans = Math.max(ans,currCount);
                currCount = (i - list.getFirst());
                list.removeFirst();
                list.addLast(i);
            }else if(list.size() == 0){
                ans = Math.max(ans,currCount );
                currCount = 0;
            }
        }
        ans = Math.max(ans,currCount );
        return ans;
	}
}
