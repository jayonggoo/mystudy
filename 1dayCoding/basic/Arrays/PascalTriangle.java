import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {

        List<List<Integer>> pascal = generate(3);


        pascal.stream().forEach(s -> s.stream().forEach(s2 -> System.out.print(s2)) );

    }


    public static List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> allrows = new ArrayList<List<Integer>>();
        ArrayList<Integer> row = new ArrayList<Integer>();

        for(int i = 0 ; i < numRows; i ++)
        {

            row.add(0, 1);

            for(int j = 1 ; j < row.size() - 1 ; j++)
            {
                row.set(j, row.get(j) + row.get(j+1));
            }

            allrows.add(new ArrayList<Integer>(row));

        }

        return allrows;
    }
}
