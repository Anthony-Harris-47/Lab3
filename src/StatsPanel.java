import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class StatsPanel extends JPanel {
    Integer[][] data;
    JLabel avgHundredthPrec;
    JLabel avgTenthPrec;
    JLabel avgInchPrec;
    JLabel avgInchSnowDepth;
    JLabel avgInchSnowFall;
    JLabel avgMinTemp0;
    JLabel avgMinTemp32;
    JLabel avgMaxTemp32;
    JLabel avgMaxTemp70;
    JLabel avgMinTemp90;
    JLabel avgFog;
    JLabel avgHeavyFog;
    JLabel avgStorms;

    public StatsPanel(Integer[][] dataArray) {
        this.setPreferredSize(new Dimension(500, 600));
        this.setBackground(Color.white);
        this.setVisible(true);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        JLabel title = new JLabel();
        title.setText("<html>Stats<br></html>");
        title.setFont(new Font("Times New Roman", 2, 50));

        avgHundredthPrec = new JLabel();
        avgTenthPrec = new JLabel();
        avgInchPrec = new JLabel();
        avgInchSnowDepth = new JLabel();
        avgInchSnowFall = new JLabel();
        avgMinTemp0 = new JLabel();
        avgMinTemp32 = new JLabel();
        avgMaxTemp32 = new JLabel();
        avgMaxTemp70 = new JLabel();
        avgMinTemp90 = new JLabel();
        avgFog = new JLabel();
        avgHeavyFog = new JLabel();
        avgStorms = new JLabel();




        data = dataArray;
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Float> averages = new ArrayList<>();

        for (int count = 1; count < 14; count++) {
            for (Integer[] row : data) {
                values.add(row[count]);
            }
                float average = (float) values.stream()
                                                .mapToInt(Integer::intValue)
                                                .average()
                                                .orElse(0.0);
            averages.add(average);

        }
        avgHundredthPrec.setText("Yearly average of days with precipitation (0.01 Inch) - " + averages.getFirst());
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
        add(avgHundredthPrec,SwingConstants.CENTER);
        add(title,SwingConstants.CENTER);

    } //constructor

    public void updateAverage(double avg1,
                              double avg2,
                              double avg3,
                              double avg4,
                              double avg5,
                              double avg6,
                              double avg7,
                              double avg8,
                              double avg9,
                              double avg10,
                              double avg11,
                              double avg12,
                              double avg13) {
        avgHundredthPrec.setText("Yearly average of days with precipitation (0.01 Inch) - " + avg1);
        avgTenthPrec.setText("Yearly average of days with precipitation (0.1 Inch) - " + avg2);
        avgInchPrec.setText("Yearly average of days with precipitation (1 Inch) - " + avg3);
        avgInchSnowDepth.setText("Yearly average of days with snow depth (1 Inch) - " + avg4);
        avgInchSnowFall.setText("Yearly average of days with snow fall (1 Inch) - " + avg5);
        avgMinTemp0.setText("Yearly average of days with Min temp > 0 - " + avg6);
        avgMinTemp32.setText("Yearly average of days with Min temp > 32 - " + avg7);
        avgMinTemp90.setText("Yearly average of days with Min temp > 90 - " + avg8);
        avgMaxTemp32.setText("Yearly average of days with Max temp > 32 - " + avg9);
        avgMaxTemp70.setText("Yearly average of days with Max temp > 90 - " + avg10);
        avgFog.setText("Yearly average of days with Fog - " + avg11);
        avgHeavyFog.setText("Yearly average of days with Heavy Fog - " + avg12);
        avgStorms.setText("Yearly average of days with at least one storm - " + avg13);
    }
}
