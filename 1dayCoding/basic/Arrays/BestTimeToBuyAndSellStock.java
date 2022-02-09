public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] array = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(array));

        // reuslt 5

    }

    public static int maxProfit(int[] array)
    {

        int maxCur = 0;
        int maxSoFar = 0;

        for(int i = 1 ; i < array.length ; i++)
        {
            maxCur = Math.max(0, maxCur += array[i] - array[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }

        return maxSoFar;
    }

}
