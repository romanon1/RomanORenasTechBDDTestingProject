package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilitiesLibrary.BrowserUtils;
import utilitiesLibrary.Driver;

public class Hooks extends BrowserUtils {
    @Before
    public void launchDriver(){
        Driver.getDriver().manage().window().maximize();
    }
    @After
    public void terminateDriver(Scenario scenario){
        if(scenario.isFailed()){
            byte [] data = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(data,"image/png",scenario.getName());
        }
        Driver.closeDriver();
    }
}
