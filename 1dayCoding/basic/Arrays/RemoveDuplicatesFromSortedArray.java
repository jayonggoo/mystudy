public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int [] array = {1, 1, 2};

        removeDuplicates(array);
    }

    public static int removeDuplicates(int[] nums)
    {
        if(nums.length == 0)
        {
            return 0;
        }

        int j = 0;

        for(int i = 1; i < nums.length ; i++)
        {
            if(nums[i] != nums[j])
            {
                nums[++j] = nums[i];
            }
        }

        return ++j;

    }
}
