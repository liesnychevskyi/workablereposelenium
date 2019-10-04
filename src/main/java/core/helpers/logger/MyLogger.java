package core.helpers.logger;

import core.helpers.resource.ResourceHelper;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyLogger
{
    private static boolean root = false;


    public static Logger getLogger(Class cls)
    {
        if (root)
        {
            return Logger.getLogger(cls);
        }
       //For Windows //PropertyConfigurator.configure(ResourceHelper.getRecoursePath("\\src\\main\\resources\\log4j.properties"));
        PropertyConfigurator.configure(ResourceHelper.getRecoursePath("/src/main/resources/log4j.properties"));
        root = true;
        return Logger.getLogger(cls);
    }

    public static void main(String[] args)
    {
        Logger log = MyLogger.getLogger(MyLogger.class);
        log.info("Configured");
        log.error("Error");
        log.debug("Debug");
    }
}
