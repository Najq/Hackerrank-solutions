import java.io.*;
import java.util.*;

class RomanNums{

    //convert for cases which have subtractive notations
    static int sub_digit(char literal_1,char literal_2,int pos, char[] c){
        c[pos++]=literal_1;
        c[pos++]=literal_2;
        return pos;
    }

    //give roman numerals form for normal cases
    static int digit(char literal_1,int rep_times,int pos, char[] c){
        for(int i = 0;i<rep_times;i++){
            c[pos++]=literal_1;
        }
        return pos;
    }

    //convert
    static void convertToRoman(int number){
        char charArr[] = new char[100001];
        int pos = 0;
        if(number <= 0){
            System.out.println("Invalid number");
        }
        while(number != 0){
            if(number >= 1000){
                pos =  digit('M',number /1000,pos,charArr);
                number = number % 1000;
            }else if(number >= 500){
                if(number < 900){
                    pos =  digit('D',number /500,pos,charArr);
                    number = number % 500;
                }else{
                    pos = sub_digit('C','M',pos,charArr);
                    number = number%100; 
                }
            }else if(number >= 100){
                if(number < 400){
                    pos =  digit('C',number /100,pos,charArr);
                    number = number % 100;
                }else{
                    pos = sub_digit('C','D',pos,charArr);
                    number = number%100; 
                }
            }else if(number >= 50){
                if(number < 90){
                    pos =  digit('L',number /50,pos,charArr);
                    number = number % 50;
                }else{
                    pos = sub_digit('X','C',pos,charArr);
                    number = number%10; 
                }
            }else if(number >= 10){
                if(number < 40){
                    pos =  digit('X',number /10,pos,charArr);
                    number = number % 10;
                }else{
                    pos = sub_digit('X','L',pos,charArr);
                    number = number%10; 
                }
            }else if(number >= 5){
                if(number < 9){
                    pos =  digit('V',number /5,pos,charArr);
                    number = number % 5;
                }else{
                    pos = sub_digit('I','X',pos,charArr);
                    number = 0; 
                }
            }else if(number >= 1){
                if(number < 4){
                    pos =  digit('I',number,pos,charArr);
                    number = 0;
                }else{
                    pos = sub_digit('I','V',pos,charArr);
                    number = 0; 
                }
            }
        }


        System.out.printf("Roman numeral is: "); 
        for (int j = 0; j < pos; j++) { 
            System.out.printf("%c", charArr[j]); 
        } 
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number, max 3999");
        int num = sc.nextInt();
        convertToRoman(num);
    }

}