import java.util.*;
public class Solution {

	public static int longestIncreasingSubsequence(int nums[]) {
		int n = nums.length;
        List<Integer> lis = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            if(lis.isEmpty() || nums[i] > lis.get(lis.size()-1)){
                lis.add(nums[i]);
            }
            else{
                int possiblePos = Collections.binarySearch(lis, nums[i]);
                if(possiblePos >=0){
                    continue;
                }
                else{
                    int insertPos = -possiblePos -1;
                    lis.set(insertPos,nums[i]);
                }
            }

        }
        
        return lis.size();
	}

}
