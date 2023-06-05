import java.util.* ;
import java.io.*; 
public class Solution
{
public static int findMinimumCoins(int amount)
    {
        int coin = 0;
        int[] arr = {1,2,5,10,20,50,100,500,1000};
        for(int i = arr.length - 1; i >= 0; i--){
            if(amount >= arr[i]){
                int co = amount / arr[i];
                amount = amount % arr[i];
                coin += co;
            }
        }
        return coin;
    }
}
