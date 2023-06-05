import java.util.ArrayList;

 class Solution {
	public static int removeDuplicates(ArrayList<Integer> arr,int n) {
		int totalCount = 0;
		int currNum = arr.get(0);
		for(int i= 1; i < arr.size(); i++){
			if(arr.get(i) == currNum){
				totalCount += 1;
			}else{
				currNum = arr.get(i);
			}
		}
		return arr.size() - totalCount;
	}
}
