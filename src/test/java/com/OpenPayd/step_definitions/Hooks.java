package com.OpenPayd.step_definitions;

import com.OpenPayd.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before("@UI")
    public void setUp(){
        Driver.get().manage().window().maximize(); // I put for Always maximize window
        Driver.get().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


    }

    @After("@UI")
    public void quit(Scenario scenario){
        //I used for take screenshoot when there is fail
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

        Driver.closeDriver();
    }
}
