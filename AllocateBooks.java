import java.util.* ;
import java.io.*; 
public class Solution {
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        int days = n;
        int chapter = m;
        long ans = 0;
        long minTime = 0;
        long maxTime = 0;
        for(int i= 0; i< time.length ; i++){
            maxTime += time[i];

        }

        while(minTime < maxTime){
            long midTime = (minTime + maxTime) / 2;
            long currtime = 0;
            int dayCount = 1;
            int flag = 1;
            for(int i = 0; i < time.length; i++){
                if(currtime + time[i] > midTime){
                    currtime = time[i];
                    dayCount++;
                    if(currtime > midTime || dayCount > days){
                        flag = 0;
                        break;
                    }
                }else{
                    currtime += time[i];
                }

            }
            if(flag == 0){
                minTime = midTime + 1;
            }else{
                maxTime = midTime;
            }
        }
        return minTime;
    }
}
