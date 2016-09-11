package simulation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Andrii Shershnov on 11/9/2016.
 */
public class FirstNumberInput{
    private final WebDriver driver;
    By firstFieldLocator = By.xpath("//div/form/input[1]");

    public FirstNumberInput(WebDriver driver){
        this.driver = driver;
    }

    public FirstNumberInput typeFirstInputData(String val){
        driver.findElement(firstFieldLocator).sendKeys(val);
        return this;
    }

}
