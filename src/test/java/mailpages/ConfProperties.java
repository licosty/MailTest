package mailpages;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfProperties {
    protected static Properties properties;

    static {
        try (InputStreamReader fis = new InputStreamReader(new FileInputStream("src/test/resources/config.properties"), StandardCharsets.UTF_8)) {
            properties = new Properties();
            properties.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
