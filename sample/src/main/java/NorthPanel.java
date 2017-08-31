
import fr.jmklab.apiopenweather.*;
import fr.jmklab.apiopenweather.exceptions.*;
import fr.jmklab.apiopenweather.models.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class NorthPanel extends JPanel implements ActionListener, ApiCallback {

    private JTextField userCity;
    private JButton submitCity;

    private SouthPanel southPanel;

    private String API_KEY;

    public NorthPanel(SouthPanel southPanel, String API_KEY) {

        setLayout(new GridLayout(1, 3));

        JLabel labelCity    = new JLabel("Saisissez votre ville");
        labelCity.setHorizontalAlignment(SwingConstants.CENTER);
        this.userCity       = new JTextField();
        this.submitCity     = new JButton("Valider");

        this.southPanel = southPanel;

        this.API_KEY = API_KEY;

        add(labelCity);
        add(userCity);
        add(submitCity);

        submitCity.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        submitCity.setEnabled(false);
        submitCity.setText("Veuillez patienter ....");


        Api api = new Api(API_KEY , userCity.getText());

        try {
            api.runCurrent(this);
            submitCity.setEnabled(false);
        } catch (IOException e1) {

            e1.printStackTrace();
        }
    }

    public void onReponse(ApiResponse response) {

        southPanel.setTempValue(response.getMain().getTemp());
        southPanel.setPressureValue(response.getMain().getPressure());
        southPanel.setHumidityValue(response.getMain().getHumidity());
        southPanel.setWindSpeedValue(response.getWind().getSpeed());

        submitCity.setEnabled(true);
        submitCity.setText("Valider");
    }

    public void onFailure(ApiHttpError e) {

        e.printStackTrace();

    }

    public void onUnthorized(ApiUnthorizedException e) {

        e.printStackTrace();
    }

    public void onRestError(ApiRestError e) {
        submitCity.setEnabled(true);
        submitCity.setText("Valider");
    }
}
