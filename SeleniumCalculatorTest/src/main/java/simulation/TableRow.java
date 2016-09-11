package simulation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Andrii Shershnov on 11/9/2016.
 */
public class TableRow{
    private String time;
    private String expression;
    private String result;

    public TableRow(WebElement webElement, int lineNum){
        this.time = webElement.findElement(By.xpath("//tr[" + lineNum + "]/td[1]")).getText();
        this.expression = webElement.findElement(By.xpath("//tr[" + lineNum + "]/td[2]")).getText();
        this.result = webElement.findElement(By.xpath("//tr[" + lineNum + "]/td[3]")).getText();
    }

    public TableRow(WebElement webElement){
        this.time = webElement.findElement(By.xpath("//td[1]")).getText();
        this.expression = webElement.findElement(By.xpath("//td[2]")).getText();
        this.result = webElement.findElement(By.xpath("//td[3]")).getText();
    }

    public String getTime() {
        return time;
    }

    public String getExpression() {
        return expression;
    }

    public String getResult() {
        return result;
    }

}
