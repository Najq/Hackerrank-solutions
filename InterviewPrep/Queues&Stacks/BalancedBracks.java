import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class BalancedBracks {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {

        Stack<Integer> stackChars = new Stack<Integer>();
        char arr[] = s.toCharArray();
        int topElement= 0;
        for(int i=0;i<s.length();i++){
            if(i>0 && !stackChars.isEmpty()){
                topElement = stackChars.peek();
            }
            stackChars.push((int)arr[i]);
            if(topElement!=0 && stackChars.size() > 1){
                if((topElement==91 && stackChars.peek() ==93) || (topElement==123 && stackChars.peek() ==125) || 
                (topElement== 40 && stackChars.peek() ==41)
                ){
                    stackChars.pop();
                    stackChars.pop();
                }
            }
        }
        String result = "";
        if(stackChars.isEmpty()){
            result = "YES";
        }else{
            result = "NO";
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
