import java.util.* ;
import java.io.*; 
public class Solution {
    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int arr[]) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        subsetUniq(0,arr,ans,new ArrayList<>());
        return ans;
    }
    public static void subsetUniq(int index, int[] arr, ArrayList<ArrayList<Integer>> ans ,ArrayList<Integer> temp){
        ans.add(new ArrayList<>(temp));
        
        if(index >= arr.length) return ;
        for(int i = index; i< arr.length ; i++){
            if(i > index && arr[i - 1] == arr[i]) continue;
            temp.add(arr[i]);
            subsetUniq(i + 1,arr,ans,temp);
            temp.remove(temp.size() - 1);
        }
    }

}
