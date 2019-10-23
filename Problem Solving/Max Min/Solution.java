/*
You will be given a list of integers arr and a single integer k. You must create an array of length k from elements of arr such that its unfairness is minimized. Call that array subarr. Unfairness of an array is calculated as
		
		max(subarr) - min(subarr)

Where:
- max denotes the largest integer in subarr
- min denotes the smallest integer in subarr
*/
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

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

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
        int[] arrSorted = performMergeSort(arr);
        int jMinimum = Integer.MAX_VALUE;
        for(int i = 0 ; i <= arrSorted.length - k ; i++){
            jMinimum = Math.min(jMinimum, arrSorted[i+k-1] - arrSorted[i]);
        }
        return jMinimum;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
