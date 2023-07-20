public class Solution
{
    public static int[][] floodFill(int[][] image, int x, int y, int newColor)
    {
         if(image[x][y] == newColor){
            return image;
        }
        boolean check = false;
        int n = image[x][y];
        int i = x, j = y;
        if(i - 1 >= 0 && j >= 0 && (image[x][y] == image[x - 1][y]) ){
            image[x][y] = newColor;
            floodFill(image,x - 1, y,newColor);
            image[x][y] = n;
        } if(i>= 0 && j - 1 >= 0 && (image[x][y] == image[x][y - 1])){
            image[x][y] = newColor;
            floodFill(image,x, y - 1,newColor);
            image[x][y] = n;
        } if(i + 1 < image.length && j >= 0 && (image[x][y] == image[x + 1][y])){
            image[x][y] = newColor;
            floodFill(image,x + 1, y,newColor);
            image[x][y] = n;
        } if(i >= 0 && j + 1 < image[0].length && (image[x][y] == image[x][y + 1])){
            image[x][y] = newColor;
            floodFill(image,x, y + 1,newColor);
            image[x][y] = n;
        }
        image[x][y] = newColor;
        return image;
    }
}

