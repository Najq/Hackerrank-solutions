import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SherlockAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        int count = 0;
        String curr_substring = "";
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j <= s.length(); j++){
                curr_substring = s.substring(i,j);

                char[] chars = curr_substring.toCharArray();
                Arrays.sort(chars);
                curr_substring = String.valueOf(chars);
                if(map.containsKey(curr_substring)){

                    int value = map.get(curr_substring);
                    count += value;

                    map.put(curr_substring, value+1);
                }else{

                    map.put(curr_substring, 1);
                }
            }
        }
        return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        scanner.close();
    }
}
