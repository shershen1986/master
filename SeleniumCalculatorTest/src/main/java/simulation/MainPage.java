package simulation;

import org.openqa.selenium.WebDriver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Andrii Shershnov on 11/9/2016.
 */
public class MainPage{
    private final WebDriver driver;
    private FirstNumberInput firstInput;
    private CalculatorOperator calculatorOperator;
    private SecondNumberInput secondInput;
    private BtnGo btnGo;
    private HistoryResultsTable historyResultsTable;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        initialize();
    }

    private void initialize(){
        firstInput = new FirstNumberInput(driver);
        calculatorOperator = new CalculatorOperator(driver);
        secondInput = new SecondNumberInput(driver);
        btnGo = new BtnGo(driver);
        historyResultsTable = new HistoryResultsTable(driver);
    }

    public MainPage waitForFinishingCalculation(){
        try {
            Method historyResult = historyResultsTable.getClass().getDeclaredMethod("isLoaded", new Class[] {});
            historyResult.invoke(historyResultsTable);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return this;
    }


    public MainPage setFirstInput(String val){
        this.firstInput.typeFirstInputData(val);
        return this;
    }

    public MainPage setOperator(String val){
        this.calculatorOperator.setOperator(val);
        return this;
    }

    public MainPage setSecondInput(String val){
        this.secondInput.typeSecondInputData(val);
        return this;
    }

    public MainPage clickBtnGo(){
        this.btnGo.clickButton();
        return this;
    }

    public HistoryResultsTable getHistoryResultsTabletControl(){
        return this.historyResultsTable;
    }

    public HistoryResultsTable.TableRow getLastValueFromHistoryTable(){
        return this.historyResultsTable.getLastRowData();
    }

}

