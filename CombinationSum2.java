import java.util.*;


public class Solution 
{
    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target)
    {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        combinationSum2Helper(0,arr,ans , new ArrayList(),target,0);
        return ans;
    }
    public static void combinationSum2Helper(int index ,ArrayList<Integer> arr,ArrayList<ArrayList<Integer>> ans , ArrayList temp , int target, int sum)
    {
        if(sum == target){
            ans.add(new ArrayList<>(temp));
        }
        if(sum > target) return;
        for(int i = index; i < arr.size(); i++ ){
            if(i > index && arr.get(i) == arr.get(i - 1)){
                continue;
            }
            temp.add(arr.get(i));
            combinationSum2Helper(i + 1,arr,ans,temp,target,sum + arr.get(i));
            temp.remove(temp.size() - 1);
        }
    }
}
