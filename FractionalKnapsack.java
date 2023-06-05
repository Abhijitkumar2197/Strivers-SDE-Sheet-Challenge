import java.util.* ;
import java.io.*; 
/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/


public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
		Arrays.sort(items,Comparator.comparing((Pair a)-> (double)-a.value/a.weight));
        double ans = 0;
        for(int i = 0; i < items.length; i++){
            if(items[i].weight <= w ){
                ans = ans + items[i].value;
                w = w- items[i].weight;
            }else{
                ans += items[i].value * ((double) w / items[i].weight);
				break;
            }
        }
        return ans;
    }
}
