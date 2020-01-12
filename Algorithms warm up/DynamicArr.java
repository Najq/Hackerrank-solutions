import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {


    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
    // Write your code here

    List<List<Integer>> seqList = new ArrayList<List<Integer>>(n); 
    List<Integer> result = new ArrayList<Integer>();
    for(int i = 0; i < n; i++)  {
        seqList.add(new ArrayList<Integer>());
    }
    int lastAnswer = 0;
    List<Integer> singleQuery = new ArrayList<Integer>();
    int seqIndex = 0;
    int seqSize = 0;
    for (int i = 0; i < queries.size(); i++) {
            singleQuery = queries.get(i);
            seqIndex = (singleQuery.get(1) ^ lastAnswer)%n;
            if(singleQuery.get(0) == 1){
                seqList.get(seqIndex).add(singleQuery.get(2));
            }
            else{
                seqSize = seqList.get(seqIndex).size();
                int y = singleQuery.get(2)%seqSize;
                lastAnswer = seqList.get(seqIndex).get(y);
                result.add(lastAnswer);
            }
        }
        return result;
    }

    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(System.out);

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> queriesRowItems = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                queriesRowItems.add(queriesItem);
            }

            queries.add(queriesRowItems);
        }

        List<Integer> result = Result.dynamicArray(n, queries);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();

        
    }

}