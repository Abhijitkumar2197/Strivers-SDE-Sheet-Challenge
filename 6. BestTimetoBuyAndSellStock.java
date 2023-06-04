import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

 class Solution{
    public static int maximumProfit(ArrayList<Integer> prices){
        int maxProfit = 0;
        int currPrice = prices.get(0);
        for(int i = 1; i <prices.size(); i++){
            if(currPrice < prices.get(i)){
                maxProfit = Math.max(maxProfit,prices.get(i) - currPrice);
            }else{
                currPrice = prices.get(i);
            }
        }
        return maxProfit;
    }
}
