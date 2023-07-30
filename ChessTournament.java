import java.util.* ;
import java.io.*; 
public class Solution {

   
   public static boolean isPossible(int[] positions, int maxSpace, int players, int n)
   {
       int Currplayers  = 1;
       int lastPos = positions[0];
       for(int i=0; i<n; i++)
       {
           if(positions[i] - lastPos >= maxSpace)
           {
             Currplayers++;
             if(Currplayers > players) return false;
             if(Currplayers == players) return true;
             lastPos = positions[i];
           }
         
       }
      return false;
   }
    public static int chessTournament(int[] positions, int n,  int c) 
	{
        // if (n == c) return 1;

        Arrays.sort(positions);
        int minDist = 0;
        int maxDist = positions[n - 1];
        int ans = -1;

        while (minDist <= maxDist) {
            int midTime = maxDist + ((minDist - maxDist) / 2);
            boolean flag = isPossible(positions, midTime, c, n);
            if (!flag) {
                maxDist = midTime - 1;
            } else {
                ans = midTime;
                minDist = midTime + 1;
            }
        }

        return ans;
    }

}
