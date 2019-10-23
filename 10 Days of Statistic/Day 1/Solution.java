/*
Given an array X of N integers, calculate and print the respective mean, median, and mode on separate lines. If your array contains more than one modal value, choose the numerically smallest one.
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void merge(int[] arr, int jLeft, int jMid ,int jRight){
        int n1 = jMid - jLeft + 1;
        int n2 = jRight - jMid;

        int[] arrLeft = new int[n1];
        int[] arrRight = new int[n2];

        for(int i = 0 ; i < n1 ; i++){
            arrLeft[i] = arr[jLeft + i];
        }
        for(int j = 0 ; j < n2 ; j++){
            arrRight[j] = arr[jMid + j + 1];
        }
        int i=0,j=0,k=jLeft;
        while(i < n1 && j < n2){
            if(arrLeft[i] < arrRight[j]){
                arr[k++] = arrLeft[i++];
            }
            else{
                arr[k++] = arrRight[j++];
            }
        }
        while(i < n1){
            arr[k++] = arrLeft[i++];
        }
        while(j < n2){
            arr[k++] = arrRight[j++];
        }
    }

    public static void mergeSort(int[] arr, int jLeft, int jRight){
        if(jLeft < jRight){
            int jMid = jLeft + (jRight-jLeft)/2;
            mergeSort(arr,jLeft,jMid);
            mergeSort(arr,jMid+1,jRight);
            merge(arr,jLeft,jMid,jRight);
        }
    }

    public static int[] performMergeSort(int[] arr){
        mergeSort(arr,0,arr.length-1);
        return arr;
    }
    static double mean(int arr[]){
        double jSum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            jSum += arr[i];
        }
        return jSum/arr.length;
    }
    static double median(int arr[]){
        if(arr.length %2 != 0)
            return arr[arr.length/2];
        else{
            return (arr[(arr.length - 1)/2] + arr[arr.length/2])/2.0;
        }
    }
    static int mode(int arr[]){
        int jMaxValue = 0;
        int jMaxCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int jCount = 0;
            for (int j = 0; j < arr.length; j++) {
                if(arr[i] == arr[j])
                    ++jCount;
                }
            if(jCount > jMaxCount){
                jMaxCount = jCount;
                jMaxValue = arr[i];
            }
        }
        return jMaxValue;
    }

    public static void main(String[] args)throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int jSize = Integer.parseInt(scan.nextLine());
        int arr[] = new int[jSize];
        for(int i = 0 ; i < jSize ; i++){            
            arr[i] = Integer.parseInt(scan.next());            
        }
        int[] arrsorted = performMergeSort(arr);
        System.out.println(mean(arrsorted));
        System.out.println(median(arrsorted));
        System.out.println(mode(arrsorted));
        scan.close();
    }
}