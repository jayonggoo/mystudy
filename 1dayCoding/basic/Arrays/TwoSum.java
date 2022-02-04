import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class TwoSum {
        
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9 ;
        int[] answer = twoSum(nums, target);
        
        Arrays.stream(answer).forEach(s -> System.out.println(s));

    }

    public static int[] twoSum(int[] nums, int target)
    {
        int[] arr = new int[2];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0 ; i < nums.length ; i++)
        {
            Integer val = map.get(target - nums[i]);

            if(val == null)
            {
                map.put(nums[i], i);
            }else{
                arr[0] = val;
                arr[1] = i;
                break;
            }
        }

        return arr;
    }
}
