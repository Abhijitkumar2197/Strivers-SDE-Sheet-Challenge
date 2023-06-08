import java.util.* ;
import java.io.*; 

public class Stack {
    int[] arr;
    int index;
    
    Stack(int num){
        arr = new int[num];
        index = 0;
        Arrays.fill(arr, -1);
    }
    void push(int num) {
        if(index == arr.length) return ;
        arr[index] = num;
        index++;
        
    }
    int pop() {
        if(index == 0)return -1;
        int a = arr[index - 1];
        index--;
        return a;
        
    }
    int top() {
        if(index == 0) return -1;
        return arr[index -1];
    }
    int isEmpty() {
        if(index == 0) return 1;
        return 0;
    }
    int isFull() {
        if(index == arr.length) return 1;
        return 0;
    }
}
