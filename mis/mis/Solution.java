package mis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static Set<int[]> mins = new HashSet<>();
    public static void sumSubarrayMins(int[] arr, int beg, int end, int sum) {
        if (beg <= end) {
            mins.add(Arrays.copyOfRange(arr, beg, end + 1));
            sumSubarrayMins(arr, beg + 1, end - 1, sum);
            sumSubarrayMins(arr, beg + 1, end, sum);
            sumSubarrayMins(arr, beg, end - 1, sum);
        }
    }

    public static int getMinimun(int [] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String args[]) {
        int arr[] = new int[]{3, 1, 2, 4};
        int sum = 0;
        Solution.sumSubarrayMins(arr, 0, arr.length - 1, sum);
        Object[] list = mins.toArray();

        for(int i =0; i< mins.size();i++){
            int min = getMinimun((int[]) list[i]);
            sum = sum + min;
        }
        System.out.println(sum);
        String num = "1234";
        char[] ch = num.toCharArray();
        System.out.println(ch);
    }
}
