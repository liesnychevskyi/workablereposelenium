package core.helpers.browser_configurations.config;

import core.helpers.browser_configurations.BrowserType;
import core.helpers.resource.ResourceHelper;

import java.io.*;
import java.util.Properties;

public class PropertyReader implements ConfigReader
{
    private static FileInputStream file;
    private static Properties OR;

    public PropertyReader()  // Load the property file to the memory
    {
//============================================================================//
        String filePath = ResourceHelper.getRecoursePath("\\src\\main\\resources\\config.properties");
        try
        {
            file = new FileInputStream(new File(filePath));
            OR = new Properties();
            OR.load(file);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
//=============================================================================//
    @Override
    public int getImpliciteWait()
    {
        return Integer.parseInt(OR.getProperty("implicitwait"));
    }

    @Override
    public int getExpliciteWait()
    {
        return Integer.parseInt(OR.getProperty("explicitwait"));
    }

    @Override
    public int getPageLoadTime()
    {
        return Integer.parseInt(OR.getProperty("pageloadtime"));
    }

    @Override
    public BrowserType getBrowserType()
    {
       return BrowserType.valueOf(OR.getProperty("browsertype"));
    }
}
