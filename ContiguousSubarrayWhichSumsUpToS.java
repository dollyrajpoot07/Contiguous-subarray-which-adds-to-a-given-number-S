// Given an unsorted array A of Size N of non-negative numbers, find a contiguous subarray which adds to a given number S.
//Input:
// N = 5, S = 12
// A[] = {1, 2, 3, 7, 5}
// Output:
// 2 4

import java.util.*;

public class ContiguousSubarrayWhichSumsUpToS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int totalSum = sc.nextInt();
        int[] array = new int[size];

        for(int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        int i = 0;
        int j = 0;
        int start = -1;
        int end = -1;
        int sum = 0;

        while(j < size && (sum + array[j] <= totalSum)) {
            sum += array[j];
            j++;
        }

        if(sum == totalSum) {
            System.out.println((i + 1) + " " + j);
        }

        while(j < size) {
            sum += array[j];
            while(sum > totalSum) {
                sum -= array[i];
                i++;
            } 
            
            if(sum == totalSum) {
                start = i + 1;
                end = j + 1;
                break;
            }
            j++;
        }
        System.out.println("From " + start + " to " + end);
        sc.close();
    }
}
