import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class SouthPanel extends JPanel {

    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    private JLabel tempLabel;
    private JLabel tempValue;

    private JLabel pressureLabel;
    private JLabel pressureValue;

    private JLabel humidityLabel;
    private JLabel humidityValue;

    private JLabel windSpeedLabel;
    private JLabel windSpeedValue;


    public SouthPanel() {

        if (RIGHT_TO_LEFT) {
            setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        }

        setLayout(new GridBagLayout());
        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 40, 10, 10), new EtchedBorder()));

        GridBagConstraints gc = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width
            gc.fill = GridBagConstraints.HORIZONTAL;
        }

        tempLabel        = new JLabel("Temperature :", JLabel.RIGHT);
        pressureLabel    = new JLabel("Pressure :", JLabel.RIGHT);
        humidityLabel    = new JLabel("Humidity :", JLabel.RIGHT);
        windSpeedLabel   = new JLabel("Wind speed :", JLabel.RIGHT);

        tempValue       = new JLabel("", JLabel.LEFT);
        pressureValue   = new JLabel("", JLabel.LEFT);
        humidityValue   = new JLabel("", JLabel.LEFT);
        windSpeedValue  = new JLabel("", JLabel.LEFT);


        gc.insets = new Insets(5, 5, 5, 5);

        if (shouldWeightX) {
            gc.weightx = 0.5;
        }
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 0;
        add(tempLabel, gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 1;
        gc.gridy = 0;
        add(tempValue, gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 2;
        gc.gridy = 0;
        add(new JLabel(""), gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 1;
        add(pressureLabel, gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 1;
        gc.gridy = 1;
        add(pressureValue, gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 2;
        gc.gridy = 1;
        add(new JLabel(""), gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 2;
        add(humidityLabel, gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 1;
        gc.gridy = 2;
        add(humidityValue, gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 2;
        gc.gridy = 2;
        add(new JLabel(""), gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 3;
        add(windSpeedLabel, gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 1;
        gc.gridy = 3;
        add(windSpeedValue, gc);

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 2;
        gc.gridy = 3;
        add(new JLabel(""), gc);




    }


    public void setTempValue(double val)  {

        tempValue.setText(val+"");

    }

    public void setPressureValue(int val) {

        pressureValue.setText(val+"");
    }

    public void setHumidityValue(int val) {

        humidityValue.setText(val+"");
    }

    public void setWindSpeedValue(double val) {

        windSpeedValue.setText(val+"");
    }


}
