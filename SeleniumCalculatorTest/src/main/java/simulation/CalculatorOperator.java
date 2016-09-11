package simulation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Andrii Shershnov on 9/9/2016.
 */
public class CalculatorOperator{
    private final WebDriver driver;

    By operatorLocator = By.xpath("//div[1]/div/form/select");

    public CalculatorOperator(WebDriver driver){
        this.driver = driver;
    }

    public CalculatorOperator setOperator(String val){
        driver.findElement(operatorLocator).sendKeys(val);
        return this;
    }
}
