package Array.Subarray.Easy;

/*

Split an array into two equal Sum subarrays

Given an array of integers greater than zero, find if it is possible to split it in two subarrays (without reordering the elements),
such that the sum of the two subarrays is the same. Print the two subarrays.

Input : Arr[] = { 4, 1, 2, 3 }
Output : {4 1}
         {2 3}

Input : Arr[] = { 4, 3, 2, 1}
Output : Not Possible
*/

public class FindSplitPoint {
    static int findSplitPoint(int[]arr, int n) {
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            leftSum += arr[i];

            int rightSum = 0;
            for (int j = i+1; j < n; j++) {
                rightSum += arr[j];
            }
            if (leftSum == rightSum){
                return i+1;
            }
        }
        return -1;
    }

    static void printTwoParts(int[]arr, int n) {
        int splitPoint = findSplitPoint(arr, n);
        if(splitPoint == -1 || splitPoint == n){
            System.out.println("Not Possible");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (splitPoint == i){
                System.out.println();
            }
            System.out.print(arr[i] + " ");
        }

    }
    public static void main(String[] args) {
        int arr[] = {4, 1, 2, 3 };
        int n = arr.length;
        printTwoParts(arr, n);
    }
}
