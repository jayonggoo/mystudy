import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {

        int []A = new int[10];
        int []B = {4, 5};

        merge(A, A.length-3,  B, B.length);

    }

    public static void merge(int A[], int m, int B[], int n)
    {
        int i = m - 1, j = n - 1, k = m+n-1;

        while(i > -1 && j > -1)
        {
            A[k--] = (A[i] > B[j]) ? A[i--] : B[j--];
        }

        while(j > -1)
            A[k--] = B[j--];

        Arrays.stream(A).forEach(num -> System.out.println(num));
    }
}
