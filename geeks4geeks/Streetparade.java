import java.util.*;
import java.io.*;

class StParade{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String listNumbers = sc.nextLine();
        String[] splitArray = listNumbers.split(" ");
        int[] numberArr =new int[splitArray.length];
        int i =0;
        for(String token: splitArray){
           numberArr[i++] = Integer.parseInt(token);
        }

        Stack<Integer> stack = new Stack<Integer>();
        int nextElement = 1;
        boolean flag= true;
        for(i=0;i<numberArr.length;i++){
            while(!stack.empty() && stack.peek() == nextElement){
                nextElement++;
                stack.pop();
            }
            if(numberArr[i] == nextElement){
                nextElement++;
            }else if(!stack.empty() && stack.peek()<numberArr[i]){
                flag =false;
                break;
            }else{
                stack.push(numberArr[i]);
            }
        }
        if(flag){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}