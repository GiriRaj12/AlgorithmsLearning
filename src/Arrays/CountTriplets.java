package Arrays;

/*
Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.

Example 1:

Input:
N = 4
arr[] = {1, 5, 3, 2}
Output: 2
Explanation: There are 2 triplets:
1 + 2 = 3 and 3 +2 = 5
â€‹Example 2:

Input:
N = 3
arr[] = {2, 3, 4}
Output: 0
Explanation: No such triplet exits
Your Task:
You don't need to read input or print anything. Your task is to complete the function countTriplet() which takes the array arr[] and N as inputs and returns the triplet count

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(1)

Constraints:
1 ≤ N ≤ 103
1 ≤ arr[i] ≤ 105
 */

import java.util.Scanner;

public class CountTriplets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int [] arr = new int[n];
        for(int i=0; i<4; i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(findTriplets(arr.length, arr));
    }

    static int findTriplets(int n, int [] arr){
        int count = 0;
        for(int i=0;i<n;i++){
            int findArr [] = getRemainingArray(arr, i);
            count += findTripletsCount(findArr, arr[i]);
        }
        return count;
    }

    private static int findTripletsCount(int[] findArr, int sumValue) {
        int tripletCount = 0;
        for(int i=0; i<findArr.length-1; i++){
            for(int j=i+1; j<findArr.length; j++){
                if(sumValue == (findArr[i] + findArr[j])){
                    tripletCount++;
                }
            }
        }
        return tripletCount;
    }

    private static int[] getRemainingArray(int[] arr, int index) {
        int retunrnArr[] = new int[arr.length -1];
        int count = 0;
        for(int i=0;i<arr.length;i++) {
            if (i == index) {
                continue;
            }
            retunrnArr[count++] = arr[i];
        }
        return retunrnArr;
    }
}
