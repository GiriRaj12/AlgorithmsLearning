package Arrays;


import java.lang.reflect.Array;
import java.util.*;

/*
 Source : Geeks for Geeks - Interview Preparation

 Question :
    Given an unsorted array A of size N of non-negative integers, find a continuous sub-array which adds to a given number S.

    Input:
    The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines.
    The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case
    contains N space separated integers denoting the array elements.

    Output:
    For each testcase, in a new line, print the starting and ending positions(1 indexing) of first such occuring subarray from the left if sum equals
    to subarray, else print -1.

    Constraints:
    1 <= T <= 100
    1 <= N <= 107
    1 <= Ai <= 1010

    Example:
    Input:
    2
    5 12
    1 2 3 7 5
    10 15
    1 2 3 4 5 6 7 8 9 10
    Output:
    2 4
    1 5

    Explanation :
    Testcase1: sum of elements from 2nd position to 4th position is 12
    Testcase2: sum of elements from 1st position to 5th position is 15
 */

public class SubarrayWithSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, List<Integer>> resultMap = new HashMap<>();
        int cases = in.nextInt();
        int key = 0;
        while(cases >= 1 ){
            int n = in.nextInt();
            int summation = in.nextInt();
            int [] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = in.nextInt();
            }
            resultMap.put(++key, findIndexes(n, summation, arr));
            --cases;
        }

        resultMap.forEach((k,v) -> {
            System.out.println("Key :" + k);
            System.out.print("Value:");
            v.stream().forEach(e -> System.out.print(e+1+" - "));
            System.out.println();
            System.out.println("---");
        });

    }

    static List<Integer> findIndexes(int n, int summation ,int [] arr){
        List<Integer> list = new ArrayList<>(2);
        for(int i=0;i<n;i++){
            int sum = 0;
            for(int j=i;j<n;j++) {
                sum = sum + arr[j];
                if(sum > summation){
                    break;
                }

                if (sum == summation) {
                    list.add(i);
                    list.add(j);
                    return list;
                }
            }
        }
        return list;
    }
}
