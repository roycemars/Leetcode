import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {8, 0, 2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] out = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for( int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                out[0] = map.get(nums[i]);
                out[1] = i;
                return out;
            }
            map.put(target - nums[i], i);
        }
        return out;
    }
}
