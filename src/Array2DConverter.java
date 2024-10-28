import java.util.List;

public class Array2DConverter {

    public static Integer[][] convertArrayOfArraysTo2D(List<Integer>[] listArray) {
        if (listArray == null || listArray.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        // Get dimensions
        int cols = listArray.length;
        int rows = listArray[0].size();

        // Create new 2D array with proper dimensions
        Integer[][] result = new Integer[rows][cols];

        // Copy elements from Lists to 2D array
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = listArray[j].get(i);
            }
        }

        return result;
    }
}