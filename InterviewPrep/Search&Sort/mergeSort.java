import java.util.*;
import java.io.*;

class mergeSort{


    void merge(int arr[], int l, int m, int r){

        int size_1 = (m-l+1);
        int size_2 = r-m;

        int L[] = new int[size_1];
        int R[] = new int[size_2];

        for(int i=0;i<size_1;i++){
            L[i] = arr[l+i];
        }
        for(int i=0;i<size_2;i++){
            R[i] = arr[m+i+1];
        }
        int left = 0;
        int right = m;
        int k = left;
        while(left < size_1 && right < size_2){
            if(L[left] <= R[right]){
                arr[k] = L[left];
                left++;
            }else{
                arr[k] = R[right];
                right++;
            }
            k++;
        }

        while(left < size_1){
            arr[k] = L[left];
            k++;
            left++;
        }

        while(right < size_2){
            arr[k] = R[right];
            k++;
            right++;
        }
    }

    void sort(int arr[],int l, int r){

        if(l < r){
            int m = (l+r)/2;
            sort(arr,l,m);
            sort(arr,m+1,r);
            
            merge(arr,l,m,r);
        }
    }

    static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String args[]){

        int arr[] = {12, 11, 13, 5, 6, 7}; 

        System.out.println("Given Array"); 
        printArr(arr); 
  
        mergeSort ob = new mergeSort(); 
        ob.sort(arr, 0, arr.length-1); 

        System.out.println("\nSorted array"); 
        printArr(arr); 

    }

}