public class Solution {
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int l) {
        int[] count = new int[row1.length + row2.length];
        int i = 0, j = 0, k=0;
        while(k < count.length){
            if(i == row1.length){
                while(j < row2.length){
                    count[k++]  = row2[j++];
                }
                break;
            }
            if(j == row2.length){
                while(i < row1.length){
                    
                    count[k++]  = row1[i++];
                }
                break;
            }
            if(row1[i] < row2[j]){
                count[k++] = row1[i++];
            }else{
                count[k++] = row2[j++];
            }

        }
        return count[l -1];
    }

    
}
