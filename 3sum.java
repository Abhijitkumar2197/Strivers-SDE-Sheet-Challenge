import java.util.* ;
import java.io.*; 
public class Solution {

	public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K)  {
	    
        Arrays.sort(arr);
        HashSet<ArrayList<Integer>> map = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            int start=i+1;
            int end=n-1;
            int sum=K-arr[i];
            while(start<end)
            {
                if((arr[start]+arr[end])==sum)
                {
                    ArrayList<Integer>one=new ArrayList<>();
                    one.add(arr[i]);
                    one.add(arr[start]);
                    one.add(arr[end]);
                    map.add(one);
                    start++;
                }
                else if((arr[start]+arr[end])<sum)
                {
                    start++;
                }
                else if((arr[start]+arr[end])>sum)
                {
                    end--;
                }
            }
        }
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ans.addAll(map);
        return ans;
	}
}
