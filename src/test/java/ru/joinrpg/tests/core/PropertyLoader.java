package ru.joinrpg.tests.core;

import java.io.FileInputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyLoader {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    String url;
    String user;
    String password;
    String master;
    
    PropertyLoader() 
    {
        url = loader().getProperty("url");
        user = loader().getProperty("user");
        master = loader().getProperty("master");
        password = loader().getProperty("password");
    }
    
    private Properties loader() {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("conf/" + System.getProperty("conf", "dev") + ".properties"));
        } catch(Exception e){
            logger.error(e.toString());
        }
        return p;
    }
}