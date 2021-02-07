package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class configDataProvider {
    Properties prop;
    public configDataProvider(){
        File src= new File("./configuration/config.properties");
        try {
            FileInputStream fis= new FileInputStream(src);
            prop= new Properties();
            prop.load(fis);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAppURL()
    {
        String url=prop.getProperty("url");
        return url;
    }
    public String getChrompath()
    {
        String url=prop.getProperty("chromePath");
        return url;
    }

}
