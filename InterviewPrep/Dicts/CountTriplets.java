import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {

        
        Map<Long,Long> middleElement = new HashMap<>();
        Map<Long,Long> lastElement = new HashMap<>();
        long result = 0L;

        for(Long a:arr){
            result += lastElement.get(a)==null?0:lastElement.get(a);
            if(middleElement.containsKey(a)){
                long val =  (lastElement.get(a*r)==null?0:lastElement.get(a*r)) + middleElement.get(a);
                lastElement.put(a*r, val);
            }
            long middleVal = (middleElement.get(a*r)==null?0:middleElement.get(a*r)) + 1;
            middleElement.put(a*r,middleVal);
        }
        return result;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Triplets.txt"));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
