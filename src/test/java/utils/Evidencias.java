package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Evidencias {
    public void print(WebDriver driver){
        File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);


    }
}
