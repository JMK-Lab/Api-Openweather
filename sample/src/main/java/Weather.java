import javax.swing.*;
import java.awt.*;

public class Weather extends JFrame {

    public Weather(String API_KEY) {

        setTitle("Weather");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 250);

        JPanel backPanel = new JPanel();

        backPanel.setLayout(new BorderLayout());

        SouthPanel southPanel = new SouthPanel();
        NorthPanel northPanel = new NorthPanel(southPanel, API_KEY);


        backPanel.add(northPanel, BorderLayout.NORTH);
        backPanel.add(southPanel, BorderLayout.SOUTH);


        setContentPane(backPanel);
        setVisible(true);
    }


}
