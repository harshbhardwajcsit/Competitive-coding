import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> listOfList = new ArrayList<>();
        int pointer1 = 0;
        int pointer3 = nums.length - 1;
        while (pointer1 + 1 < pointer3) {
            int sum = nums[pointer1] + nums[pointer1 + 1] + nums[pointer3];
            if (sum == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[pointer1]);
                list.add(nums[pointer1 + 1]);
                list.add(nums[pointer3]);
                listOfList.add(list);
                pointer1 ++;
                pointer3 --;

            } else if (sum < 0) {
                pointer1++;
            } else {
                pointer3--;
            }
        }
        return listOfList;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
}
