import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the climbingLeaderboard function below.
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
            int[] result = new int[alice.length];
            HashMap<Integer, Integer> map = new HashMap<>();
            int temp = scores[0];
            int count =1;
            map.put(count, scores[0]);
            for(int i=1;i< scores.length;i++){
                if(scores[i] != temp){
                    count = count+1;
                    map.put(count,scores[i]);
                    temp = scores[i];
                }
            }
                         
             for(int i=0;i< alice.length;i++){
                 int rank=0;
                  Iterator it = map.entrySet().iterator(); 
                 while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    int comparisonTemp = (Integer)pair.getValue();
                    if(alice[i] >= comparisonTemp){
                        rank=(Integer)pair.getKey();
                        break;
                    }
                 }
                 if(rank == 0){
                     rank = count +1;
                 }
                 result[i]=rank;
             }
             return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
