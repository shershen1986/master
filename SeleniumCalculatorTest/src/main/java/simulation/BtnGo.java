package simulation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Andrii Shershnov on 11/9/2016.
 */
public class BtnGo{
    private final WebDriver driver;
    By btnGoLocator = By.xpath(".//*[@id='gobutton']");

    public BtnGo(WebDriver driver){
       this.driver = driver;
    }

    public BtnGo clickButton(){
        driver.findElement(btnGoLocator).click();
        return this;
    }
}
