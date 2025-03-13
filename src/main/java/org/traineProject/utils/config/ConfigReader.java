package org.traineProject.utils.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class ConfigReader {
    private static final Properties PROPERTIES = new Properties();

    public static void readProperties() {
        if (PROPERTIES.isEmpty()) {
            try {
                InputStream inputStream = ClassLoader.getSystemResourceAsStream("config.properties");
                PROPERTIES.load(inputStream);
            } catch (IOException e) {
                throw new RuntimeException("Ошибка загрузки конфигурационного файла", e);
            }
        }
    }

    public static String getConfigProperties(String key) {
        return PROPERTIES.getProperty(key);
    }
}
