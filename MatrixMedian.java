import java.util.ArrayList;
import java.util.*;

public class Solution
{
	public static int getMedian(ArrayList<ArrayList<Integer>> matrix)
	{
		PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < matrix.size(); i++){
            for(int j = 0; j < matrix.get(0).size(); j++){
                pq.add(matrix.get(i).get(j));
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }

        if(list.size() % 2 != 0){
            return  list.get(list.size() / 2);
        }
        int n = list.size();
        return ((list.get(n /2) + list.get(n -1) )/ 2);
	}
}
