import java.util.* ;
import java.io.*; 
public class Solution {
    public static Boolean wordBreak(String[] arr, int n, String target) {
        for(int i = 0; i < arr.length; i++){
            if(target.contains(arr[i])){
                target = target.replace(arr[i], "");
                i = -1;
            }
        }
        return target.isEmpty();
    }
}
