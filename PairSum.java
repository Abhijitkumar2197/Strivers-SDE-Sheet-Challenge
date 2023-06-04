import java.io.*;
import java.util.* ;

 class Solution{
    public static List<int[]> pairSum(int[] arr, int s) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i] ,map.getOrDefault(arr[i],0) + 1);
        }
        for(int i = 0; i < arr.length; i++){
            int a = arr[i];
            if(map.containsKey(a) && map.get(a) > 0){
                if(map.get(a) == 1){
                    map.remove(a);
                }else {
                    map.put(a,map.get(a) - 1);
                }
                int req = s - a;
                if(map.containsKey(req)){
                    for(int k = 0; k < map.get(req); k++){
                        int[] arrray = {a, req};
                        Arrays.sort(arrray);
                        ans.add(arrray);
                    }
                }

            }
        }
        return ans;
    }
}
