import java.util.ArrayList;
import java.util.List;

public class findAllDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        int[] freq = new int[nums.length + 1];
        for(int i = 0;i< nums.length;i++){
            if(freq[nums[i]] == 0){
                freq[nums[i]] = 1;
            }
            else {
                freq[nums[i]] = freq[nums[i]] + 1;
            }
        }
        final List<Integer> list = new ArrayList<>();
        for(int i =0;i< freq.length; i++){
            if(freq[i] == 2){
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }
}
