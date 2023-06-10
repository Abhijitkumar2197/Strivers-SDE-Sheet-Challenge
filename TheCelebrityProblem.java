import java.util.* ;
import java.io.*; 
/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
public class Solution {
	public static int findCelebrity(int n) {
        // Write your code here.
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i = 0; i < n; i++){
			list.add(new ArrayList<>());
		}
		boolean[] isKnow = new boolean[n];
		for(int i = 0; i < n ; i++){
			for(int j = 0; j < n ; j++){
				if( i== j) continue;
				if(Runner.knows(j,i)){
					isKnow[j] = true;
					list.get(i).add(j);
				}
			}

		}
		for(int i = 0; i < n; i++){
			if(list.get(i).size() == n - 1 && !isKnow[i]) return i;
		}
		return -1;
    }
}
