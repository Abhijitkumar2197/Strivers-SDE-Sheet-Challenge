import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

public class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k)
	{
		if (kArrays.size() == 0) {
            return new ArrayList<>();
        }
        return caller(0, kArrays.size() - 1, kArrays);
    }

    public static ArrayList<Integer> caller(int start, int end, ArrayList<ArrayList<Integer>> lists) {
        if (start == end) {
            return lists.get(start);
        }
        if (start + 1 == end) {
            ArrayList<Integer> a = mergeSort2(lists.get(start), lists.get(end));
            return a;
        }
        int mid = start + (end - start) / 2;
        ArrayList<Integer> b = caller(start, mid, lists);
        ArrayList<Integer> c = caller(mid + 1, end, lists);
        if (b == null) {
            return c;
        }
        if (c == null) {
            return b;
        }
        return mergeSort2(b, c);
    }

    public static ArrayList<Integer> mergeSort2(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int i = 0, j = 0;

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
	}
}
