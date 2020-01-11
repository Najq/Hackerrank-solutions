import java.io.*;
import java.math.*;
import java.nio.file.ReadOnlyFileSystemException;
import java.text.*;
import java.util.*;


class LFSTACK{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            int threads = sc.nextInt();
            int  listOfArrays[][] = new int[threads][];
            int numberOfElements = 0;
            for(int i=0;i<threads;i++){
                int a =sc.nextInt();
                numberOfElements += a;
                listOfArrays[i] = new int[a];
                for(int k=0;k<a;k++){
                    listOfArrays[i][k]=sc.nextInt();
                }
            }
            int stack[] = new int[numberOfElements];
            for(int i=0;i<numberOfElements;i++){
                stack[i]= sc.nextInt();
            }
            int countersForEachArr[] = new int[numberOfElements];
            boolean result = lfstack(listOfArrays,countersForEachArr, stack,numberOfElements-1);
            if(result){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
            t--;

        }
        
    }

    private static boolean lfstack(int[][] listOfArrays, int[] countersForEachArr,int[] stack,int stackPointer){

        if(stackPointer == -1){
            return true;
        }else{
            for(int i=0;i<listOfArrays.length;i++){
                if(listOfArrays[i].length>countersForEachArr[i] && listOfArrays[i][countersForEachArr[i]] == stack[stackPointer] ){
                    countersForEachArr[i]++;
                    if(lfstack(listOfArrays, countersForEachArr,stack,stackPointer-1)){
                        return true;
                    }
                }
            }

            return false;  
        }

    }



}
