package org.freeshr.identity.repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Repository {

    protected Properties loadProperties() {
        Properties properties = new Properties();
        String propFileName = "userDetail.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        try{
            if (inputStream != null)
                properties.load(inputStream);
        }

        catch (IOException e){
            System.out.println("property file '" + propFileName + "' not found in the classpath");
        }
        return properties;
    }
}
