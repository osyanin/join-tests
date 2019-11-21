package ru.joinrpg.tests.core;

import java.io.FileInputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SiteConnection {
    private static Logger logger = LoggerFactory.getLogger(SiteConnection.class);

    String url;
    String user;
    String password;
    String master;

    private static Properties loadProperties() {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("conf/" + System.getProperty("conf", "dev") + ".properties"));
        } catch(Exception e){
            logger.error(e.toString());
        }
        return p;
    }

    public static SiteConnection load() {
        Properties props = loadProperties();
        SiteConnection conn = new SiteConnection();

        conn.url = props.getProperty("url");
        conn.user = props.getProperty("user");
        conn.master = props.getProperty("master");
        conn.password = props.getProperty("password");

        return conn;
    }
}