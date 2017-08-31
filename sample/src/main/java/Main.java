import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        Properties prop = new Properties();

        try (InputStream input = Main.class.getResourceAsStream("/config.properties")) {
            prop.load(input);

            String API_KEY = prop.getProperty("API_KEY");

            Weather weather = new Weather(API_KEY);

        } catch (IOException ex) {
            ex.printStackTrace();
        }



    }
}
