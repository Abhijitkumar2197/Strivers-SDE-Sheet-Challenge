import java.io.*;
import java.util.* ;

import java.util.ArrayList;

 class Solution 
{
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) 
    {
         HashMap<Integer,Integer> map = new HashMap<>();
        int minimumTimes = arr.size() / 3;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.size(); i++){
            map.put(arr.get(i) , map.getOrDefault(arr.get(i),0) + 1);
            if(map.get(arr.get(i)) > minimumTimes){
                set.add(arr.get(i));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>(set);
        return ans;
    }
}
