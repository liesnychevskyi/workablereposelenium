package core.helpers.switch_frame;

import core.helpers.logger.MyLogger;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper
{
    private WebDriver driver;
    private Logger log = MyLogger.getLogger(FrameHelper.class);

    /**
     * Constructor for using the driver
     * @param driver
     */
    //=============================================================//
    public FrameHelper(WebDriver driver)
    {
        this.driver = driver;
    }

    /**
     * This method will switch to frame base on fame index
     * @param frameIndex
     */
    //=============================================================//
    public void switchToFrame(int frameIndex)
    {
        driver.switchTo().frame(frameIndex);
        log.info("Switch to : " + frameIndex + " frame");
    }

    /**
     * This method will switch frame based on name of frame
     * @param frameName
     */
    //=============================================================//
    public void switchToFrame(String frameName)
    {
        driver.switchTo().frame(frameName);
        log.info("Switch to : " + frameName + " frame");
    }

    /**
     * This method will switch frame based on WebElement of frame
     * @param element
     */
    //=============================================================//
    public void switchToFrame(WebElement element)
    {
        driver.switchTo().frame(element);
        log.info("Switch to frame " + element.toString());
    }
    //=============================================================//

}
