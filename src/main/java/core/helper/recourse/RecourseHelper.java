package core.helper.recourse;

public class RecourseHelper
{
    public static String getRecoursePath(String path)
    {
        String basePath = System.getProperty("user.dir");
        return basePath + path;
    }
}
