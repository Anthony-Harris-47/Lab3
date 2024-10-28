import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class StatsPanel extends JPanel {
    Integer[][] data;
    public StatsPanel(Integer[][] dataArray) {
        this.setPreferredSize(new Dimension(800, 600));
        this.setBackground(Color.gray);
        this.setVisible(true);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        JLabel title = new JLabel();
        title.setText("<html>Stats<br></html>");
        title.setFont(new Font("Times New Roman", 2, 30));

        JLabel avgHundrethPrec = new JLabel();
        JLabel avgTenthPrec = new JLabel();
        JLabel avgInchPrec = new JLabel();
        JLabel avgInchSnowDepth = new JLabel();
        JLabel avgInchSnowFall = new JLabel();
        JLabel avgMinTemp0 = new JLabel();
        JLabel avgMinTemp32 = new JLabel();
        JLabel avgMaxTemp32 = new JLabel();
        JLabel avgMaxTemp70 = new JLabel();
        JLabel avgMinTemp90 = new JLabel();
        JLabel avgFog = new JLabel();
        JLabel avgHeavyFog = new JLabel();
        JLabel avgStorms = new JLabel();




        data = dataArray;
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Float> averages = new ArrayList<>();

        for (int count = 1; count < 14; count++) {
            for (Integer[] row : data) {
                //System.out.println(Arrays.toString(new Integer[]{row[count]}));
                values.add(row[count]);
                //System.out.println(values);
            }
                float average = (float) values.stream()
                                                .mapToInt(Integer::intValue)
                                                .average()
                                                .orElse(0.0);
            averages.add(average);

        }
        avgHundrethPrec.setText("Yearly average of days with precipitation (0.01 Inch) - " + averages.getFirst());
        avgTenthPrec.setText("Yearly average of days with precipitation (0.1 Inch) - " + averages.get(1));
        avgInchPrec.setText("Yearly average of days with precipitation (1 Inch) - " + averages.get(2));
        avgInchSnowDepth.setText("Yearly average of days with snow depth (1 Inch) - " + averages.get(3));
        avgInchSnowFall.setText("Yearly average of days with snow fall (1 Inch) - " + averages.get(4));
        avgMinTemp0.setText("Yearly average of days with Min temp > 0 - " + averages.get(5));
        avgMinTemp32.setText("Yearly average of days with Min temp > 32 - " + averages.get(6));
        avgMinTemp90.setText("Yearly average of days with Min temp > 90 - " + averages.get(9));
        avgMaxTemp32.setText("Yearly average of days with Max temp > 32 - " + averages.get(7));
        avgMaxTemp70.setText("Yearly average of days with Max temp > 90 - " + averages.get(8));
        avgFog.setText("Yearly average of days with Fog - " + averages.get(10));
        avgHeavyFog.setText("Yearly average of days with Heavy Fog - " + averages.get(11));
        avgStorms.setText("Yearly average of days with at least one storm - " + averages.get(12));






        System.out.println(averages);
        add(avgStorms, SwingConstants.CENTER);
        add(avgHeavyFog, SwingConstants.CENTER);
        add(avgFog, SwingConstants.CENTER);
        add(avgMaxTemp70, SwingConstants.CENTER);
        add(avgMaxTemp32, SwingConstants.CENTER);
        add(avgMinTemp90, SwingConstants.CENTER);
        add(avgMinTemp32, SwingConstants.CENTER);
        add(avgMinTemp0, SwingConstants.CENTER);
        add(avgInchSnowFall, SwingConstants.CENTER);
        add(avgInchSnowDepth, SwingConstants.CENTER);
        add(avgInchPrec, SwingConstants.CENTER);
        add(avgTenthPrec,SwingConstants.CENTER);
        add(avgHundrethPrec,SwingConstants.CENTER);
        add(title,SwingConstants.CENTER);

    } //constructor

}
