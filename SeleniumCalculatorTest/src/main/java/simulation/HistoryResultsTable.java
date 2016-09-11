package simulation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii Shershnov on 11/9/2016.
 */
public class HistoryResultsTable extends LoadableComponent<HistoryResultsTable> {
    private final WebDriver driver;
    private By tableLocator = By.xpath(".//div[1]/table/tbody/tr");
    private By currResult = By.xpath(".//div/div/form/h2");

    private List<TableRow> currentResults;

    public HistoryResultsTable(WebDriver driver) {
        this.driver = driver;
    }

    public List<TableRow> getResultTable(){
        isLoaded();
        currentResults = new ArrayList<TableRow>();
        List<WebElement> tmp = driver.findElements(tableLocator);
        for(int i = 0; i < tmp.size(); i++){
            WebElement wb = tmp.get(i);
            currentResults.add(new TableRow(wb, i + 1));
        }
        return currentResults;
    }

    public TableRow getLastRowData(){
        return new TableRow(driver.findElement(By.xpath(".//div[1]/table/tbody/tr[1]")));
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        try {
            int tries = 3;
            String result = driver.findElement(currResult).getText();
            while(tries > 0 && !result.matches("(?i)[a-z]+|[-0-9]+\\.?[0-9]?+")) {
                tries--;
                Thread.sleep(1000);
                result = driver.findElement(currResult).getText();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
