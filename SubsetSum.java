import java.util.* ;
import java.io.*; 
public class Solution {
    public static ArrayList<Integer> subsetSum(int num[]) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        recursionSubset(0, num,0,ans);
        Collections.sort(ans);
        return ans;
    }
    public static void recursionSubset(int index , int[] nums, int sum ,ArrayList<Integer> ans){
        if(index == nums.length){
            ans.add(sum);
            return ;
        }
        recursionSubset( index + 1, nums, sum + nums[index], ans);
        recursionSubset(index + 1, nums,sum, ans);
    }

}
