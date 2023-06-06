import java.util.*;
public class Solution 
{
    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) 
	{
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subsetUniq3(0,arr,ans,new ArrayList<>(),0,k);
        return ans;
    }
    public static void subsetUniq3(int i, ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> ans ,ArrayList<Integer> temp,int sum,int k){
        if(i == arr.size()){
            if(sum == k) ans.add(new ArrayList<>(temp));
            return;
        }
        subsetUniq3(i + 1,arr,ans,temp,sum,k);
        temp.add(arr.get(i));
        subsetUniq3(i + 1,arr,ans,temp,sum + arr.get(i),k);
        temp.remove(temp.size() - 1);
    }   
}
