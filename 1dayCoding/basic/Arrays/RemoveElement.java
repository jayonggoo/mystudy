public class RemoveElement {

    public static void main(String[] args) {

        int []nums = {3, 2, 2, 3};
        int val = 3;

        System.out.println(removeElement(nums, val));

    }

    public static int removeElement(int[] nums, int val)
    {
        if(nums.length == 0) return 0;

        int slow = 0;
        for(int fast = 0 ; fast < nums.length ; fast++)
        {
            if(nums[fast] != val)
            {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
