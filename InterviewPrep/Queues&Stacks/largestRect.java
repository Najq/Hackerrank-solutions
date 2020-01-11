import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        Stack<Integer> position = new Stack<Integer>();
        h[h.length]=0;
        int maxSize = Integer.MIN_VALUE;
        int tempheight, tempPos =0;
        int currentHeight,i = 0;

        while(i < h.length){
            if(position.empty() || h[i] > h[position.peek()]){
                position.push(i);
                i++;
            }else{
                int t =position.pop();                
                maxSize = Math.max(maxSize, (h[t] *(position.empty()?i: i- position.peek() -1)));
            }
        }
        
        return maxSize;
    }

    //private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        Scanner scanner =new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        System.out.println(result);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
