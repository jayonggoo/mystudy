public class MissingNumberTest {
    public static void main(String[] args) {
        int [] array = {0,1,3};
        System.out.println(missingNumber(array));
    }

    public static int missingNumber(int[] nums)
    {
        int xor = 0;
        int i = 0;

        for (i = 0  ; i < nums.length ; i++)
        {
            xor = xor ^ i ^ nums[i];
        }

        return xor ^ i;
    }
}
