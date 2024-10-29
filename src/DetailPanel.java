import javax.swing.*;
import java.awt.*;

public class DetailPanel extends JPanel{
    public JLabel detail1;
    public JLabel detail2;
    public JLabel detail3;
    public JLabel detailsLabel;

    public DetailPanel(){
        //set size and background color
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.white);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        //details title
        detailsLabel = new JLabel("Select a row to view details", SwingConstants.CENTER);
        detailsLabel.setFont(new Font("Times New Roman", 2, 50));

        //weather averages labels
        detail1 = new JLabel("Total days with rain: 0");
        detail1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        detail2 = new JLabel("Total days with snow: 0");
        detail2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        detail3 = new JLabel("Total days with fog or storms: 0");
        detail3.setFont(new Font("Times New Roman", Font.PLAIN, 25));

        //add labels
        add(detail3, SwingConstants.CENTER);
        add(detail2, SwingConstants.CENTER);
        add(detail1, SwingConstants.CENTER);
        add(detailsLabel, SwingConstants.CENTER);
    }

    //update details when row is selected in table
    public void updateDetails(String d1, String d2, String d3) {
        detail1.setText("Total days with rain: " + d1);
        detail2.setText("Total days with snow: " + d2);
        detail3.setText("Total days with fog or storms: " + d3);

    }
}
