/*
You are in charge of the cake for your niece's birthday and have decided the cake will have one candle for each year of her total age. 
When she blows out the candles, she’ll only be able to blow out the tallest ones. 
Your task is to find out how many candles she can successfully blow out.

For example, if your niece is turning 4 years old, and the cake will have 4 candles of height 4, 4, 1, 3 
she will be able to blow out 2 candles successfully, since the tallest candles are of height 4 and there are 2 such candles.
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

    public static int[] performMergesort(int[] arr){
        mergeSort(arr,0,arr.length-1);
        return arr;
    }

    // Complete the birthdayCakeCandles function below.
    static int birthdayCakeCandles(int[] arr) {
        int[] arrSorted = performMergesort(arr);
        int jMax = arrSorted[arrSorted.length -1];
        int jCount = 1;
        for(int i = arrSorted.length - 2 ; i >= 0 ; i--){
            if(jMax == arrSorted[i])
                jCount += 1;
            else
                break;
        }
        return jCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
