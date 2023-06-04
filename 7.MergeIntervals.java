import java.util.* ;
import java.io.*; 
/*******************************************************

    Following is the Interval class structure

    class Interval {
        int start, int finish;

        Interval(int start, int finish) {
            this.start =  start;
            this.finish = finish;
        }
    }
    
*******************************************************/

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public static List<Interval> mergeIntervals(Interval[] intervals) {
        Arrays.sort(intervals,(a,b) -> a.start - b.start);
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(intervals[0].start, intervals[0].finish));
        int j = 0;
        for(int i = 1 ; i < intervals.length; i++){
            if(intervals[i].start <= list.get(list.size() - 1).finish){
                Interval in = list.remove(list.size() - 1);
                int mx = Math.max(in.finish , intervals[i].finish);
                list.add(new Interval(in.start,mx));
            }else{
                list.add(new Interval(intervals[i].start, intervals[i].finish));
            }
        }
        return  list;
    }
}
