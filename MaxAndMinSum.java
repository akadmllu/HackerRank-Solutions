/*
Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.

For example, arr = [1,3,5,7,9]. Our minimum sum is 1 + 3 + 5 + 7 = 16 and our maximum sum is 3 + 5 + 7 + 9 = 24. 

We would print
16 24
*/

import java.util.Scanner;

public class MaxAndMinSum {

    public void merge(int[] arr, int jLeft, int jMid ,int jRight){
        int n1 = jMid - jLeft + 1;
        int n2 = jRight - jMid;

        int[] arrLeft = new int[n1];
        int[] arrRight = new int[n2];

        for(int i = 0 ; i < n1 ; i++){
            arrLeft = arr[jLeft + i];
        }
        for(int j = 0 ; j < n2 ; j++){
            arrRight = arr[jMid + j + 1];
        }
        int i=0,j=0,k=jLeft;
        while(i < n1 && j < n2){
            if(arrLeft[i] < arrRight[j]){
                arr[k++] = arrLeft[i++];
            }
            else{
                arr[k++] = arrRight[j++]
            }
        }
        while(i < n1){
            arr[k++] = arrLeft[i++];
        }
        while(j < n2){
            arr[k++] = arrRight[j++]
        }
    }

    public void mergeSort(int[] arr, int jLeft, int jRight){
        if(jLeft < jRight){
            int jMid = jLeft + (jRight-left)/2;
            MergeSort(arr,jLeft,jMid);
            MergeSort(arr,jMid+1,jRight);
            Merge(arr,jLeft,jMid,jRight);
        }
    }

    public int[] performMergesort(int[] arr){
        mergeSort(arr,0,arr.length);
        return arr;
    }

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        int arrSorted = performMergeSort(arr);
        long jMinSum = 0,jMaxSum = 0;
        for(int i = 0 ; i < arrSorted.length ; i++){
            if( i < arrSorted.length - 1){
                jMinSum += arrSorted[i];
            }
            if(i > 0){
                jMaxSum += arrSorted[i];
            }
        }
        System.out.println(jMinSum + "  " + jMaxSum)
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}