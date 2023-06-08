import java.util.* ;
import java.io.*; 
public class Solution {
	public static ArrayList<ArrayList<Integer>> pwset(ArrayList<Integer> arr) {
		// WRITE YOUR CODE HERE
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        pwsetHelper(arr,ans,0,new ArrayList<>());
        return ans;
	}
	public static void pwsetHelper(ArrayList<Integer> arr , ArrayList<ArrayList<Integer>> ans, int index, ArrayList<Integer> temp) {
        if(index == arr.size()){
            ans.add(new ArrayList<>(temp));
            return ;
        }
        // WRITE YOUR CODE HERE
        pwsetHelper(arr,ans,index + 1,temp);
        temp.add(arr.get(index));
        pwsetHelper(arr,ans,index + 1, temp);
        temp.remove(temp.size() - 1);

    }
}

