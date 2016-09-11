package simulation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Andrii Shershnov on 11/9/2016.
 */
public class SecondNumberInput{
    private final WebDriver driver;
    By secondFieldLocator = By.xpath("//div/form/input[2]");

    public SecondNumberInput(WebDriver driver){
        this.driver = driver;
    }

    public SecondNumberInput typeSecondInputData(String val){
        driver.findElement(secondFieldLocator).sendKeys(val);
        return this;
    }
}
