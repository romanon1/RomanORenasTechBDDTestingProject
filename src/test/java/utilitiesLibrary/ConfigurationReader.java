package utilitiesLibrary;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties configFile;
    static {
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/resources/configuration.properties");
            configFile = new Properties();
            configFile.load(fileInputStream);
            fileInputStream.close();
        } catch (Exception e) {
            System.out.println("Failed to load properties");
            e.printStackTrace();
        }
    }
    public static String getProperties(String key) {
        return configFile.getProperty(key);
    }
}
