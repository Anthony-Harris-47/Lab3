import javax.swing.*;
import java.awt.*;

public class DetailPanel extends JPanel{
    public JLabel detail1;
    public JLabel detail2;
    public JLabel detail3;
    public JLabel detailsLabel;

    public DetailPanel(){
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.white);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        detailsLabel = new JLabel("Select a row to view details", SwingConstants.CENTER);
        detailsLabel.setFont(new Font("Times New Roman", 2, 50));

        detail1 = new JLabel("Detail 1");
        detail1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        detail2 = new JLabel("Detail 2");
        detail2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        detail3 = new JLabel("Detail 2");
        detail3.setFont(new Font("Times New Roman", Font.PLAIN, 25));

        add(detail3, SwingConstants.CENTER);
        add(detail2, SwingConstants.CENTER);
        add(detail1, SwingConstants.CENTER);
        add(detailsLabel, SwingConstants.CENTER);
    }

    public void updateDetails(String d1, String d2, String d3) {
        detail1.setText("Total days with rain: " + d1);
        detail2.setText("Total days with Snow: " + d2);
        detail3.setText("Total days with fog or storms: " + d3);

    }
}
