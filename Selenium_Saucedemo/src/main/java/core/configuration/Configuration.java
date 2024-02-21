package core.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private String filePath;
    private InputStream input;
    private Properties props;
    public Configuration(String filePath){
        this.filePath = filePath;
    }

    public String getProperty(String propertyName) {
        String result = "";
        try {
            this.props = new Properties();
            this.input = new FileInputStream(this.filePath);

            if (input != null) {
                props.load(input);
            } else throw new FileNotFoundException(String.format("Properties file %s not found", filePath));
            result = props.getProperty(propertyName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}