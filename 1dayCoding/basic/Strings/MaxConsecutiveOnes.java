public class MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums){

        int maxHere = 0, max = 0;

        for(int n : nums)
        {
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        }

        return max;
    }
}
