import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) {
         int [] f=new int[26];
         int count=0;
         for(char c:first.toCharArray())
         {
             f[c-'a']++;           
         }
         for(char c:second.toCharArray())
         {
             f[c-'a']--;
         }
        for(int i:f)
        {
            count+=Math.abs(i);
        }
        return count;
      
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
