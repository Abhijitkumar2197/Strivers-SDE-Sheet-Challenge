import java.util.ArrayList;
 class Solution {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        int row = mat.size();
        int col = mat.get(0).size();
        int s = 0 , e = (mat.size() * mat.get(0).size()) - 1;
        while(s <= e){
            int mid = (s + (e - s)/2);
            if(mat.get(mid / col).get(mid % col).equals(target)) return true;
            else if(mat.get(mid / col).get(mid % col) < target) s = mid + 1;
            else e = mid - 1;
        }
        return false;
    }
}
