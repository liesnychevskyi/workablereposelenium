package core.helpers.docker;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class SetUp_DockerGrid_macos
{
    //@BeforeTest
    //@Test(priority = 1)
    public void startDockerGrid() throws IOException, InterruptedException
    {
        String [] cmdArray = new String[2];
        cmdArray[0] = "open";
        cmdArray[1] = "/Users/Stan/IdeaProjects/workablereposelenium/docker_grid_start_macos";
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec(cmdArray);
        Thread.sleep(5000);
    }

    //@AfterTest
    //@Test(priority = 2)
    public void  stopDockerGrid() throws IOException, InterruptedException
    {

        String [] cmdArray = new String[2];
        cmdArray[0] = "open";
        cmdArray[1] = "/Users/Stan/IdeaProjects/workablereposelenium/docker_grid_stop_macos";
        Runtime rt = Runtime.getRuntime();
        Process proc = rt.exec(cmdArray);
        Thread.sleep(5000);
        Runtime.getRuntime().exec("killall Terminal"); // close all command prompts
    }
}
