package core;

import java.io.FileInputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class PropertyLoader extends Variables{
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    String url;
    
    PropertyLoader() 
    {
        url = loader().getProperty("url");
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