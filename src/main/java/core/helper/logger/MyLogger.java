package core.helper.logger;

import core.helper.recourse.RecourseHelper;
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
        PropertyConfigurator.configure(RecourseHelper.getRecoursePath("\\src\\main\\resources\\log4j.properties"));
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
