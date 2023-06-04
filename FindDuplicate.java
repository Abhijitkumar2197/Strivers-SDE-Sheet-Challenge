import java.io.*;
import java.util.* ;

import java.util.ArrayList;

 class Solution{
    public static int findDuplicate(ArrayList<Integer> arr, int n){
        HashSet<Integer> set = new HashSet<>();
        for(int i  =0; i < arr.size(); i++){
            if(set.contains(arr.get(i))) return arr.get(i);
            set.add(arr.get(i));
        }
        return 0;
    }
}
