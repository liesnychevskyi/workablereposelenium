package core.helpers.browser_configurations.config;

import core.helpers.browser_configurations.BrowserType;

public interface ConfigReader
{
    public int getImpliciteWait();
    public int getExpliciteWait();
    public int getPageLoadTime();
    public BrowserType getBrowserType();
}
