import org.jfree.data.category.DefaultCategoryDataset;

public class DatasetCreator {

    public DefaultCategoryDataset createDatasetFrom2DArray(Integer[][] data) {
        String[] seriesLabels = {"Series 1", "Series 2", "Series 3", "d", "f", "f", "f", "k", "k", "l", "k"};
        String[] categoryLabels = {"Category 1", "Category 2", "Category 3", "d", "f", "f", "f", "k", "k", "l", "l"};
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                int value = data[row][col];
                dataset.addValue(value, seriesLabels[col], categoryLabels[row]);
            }
        }
        return dataset;
    }
}
