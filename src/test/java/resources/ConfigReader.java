package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static String getGlobalValue(String key) throws IOException {

        Properties prop =new Properties();
        FileInputStream fis =new FileInputStream("./src/test/resources/Config.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }
}
