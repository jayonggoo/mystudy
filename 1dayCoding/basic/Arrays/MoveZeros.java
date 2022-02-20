import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] array = {0, 1, 0, 3, 12};
        moveZeroes(array);
    }

    public static void moveZeroes(int[] nums)
    {
        if(nums == null || nums.length == 0)
        {
            return;
        }

        int insertPos = 0;

        for(int num : nums)
        {
            if(num != 0)
            {
                nums[insertPos++] = num;
            }
        }

        while(insertPos < nums.length)
        {
            nums[insertPos++] = 0;
        }


        Arrays.stream(nums).forEach(s -> System.out.println(s));
    }
}
