package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Helper {
    public static String captureScreenShot(WebDriver driver,String screenshotname)
    {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        String dest="/Users/naveentedla/Downloads/ATF/screenshots/"+screenshotname+System.currentTimeMillis()+".png";
        try {
            FileUtils.copyFile(src,new File(dest));
        } catch (IOException e) {
            System.out.println("Failed to capture screenshots"+e.getMessage());
        }
        return dest;
    }
}
