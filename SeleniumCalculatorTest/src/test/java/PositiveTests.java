import data.provider.DataProviderForPositiveTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Andrii Shershnov on 11.09.2016.
 */
public class PositiveTests extends BaseTest {

    @Test(dataProvider = "addition-provider", dataProviderClass = DataProviderForPositiveTests.class)
    public void additionTest(String firstInput, String secInput, String expectedRes){
       Assert.assertEquals(mainPageObj
                        .setFirstInput(firstInput)
                       .setOperator("+")
                       .setSecondInput(secInput)
                       .clickBtnGo()
                       .waitForFinishingCalculation()
                       .getLastValueFromHistoryTable()
                       .getResult()
        ,expectedRes);
    }

    @Test(dataProvider = "subtraction-provider", dataProviderClass = DataProviderForPositiveTests.class)
    public void subtractionTest(String firstInput, String secInput, String expectedRes){
        Assert.assertEquals(mainPageObj
                .setFirstInput(firstInput)
                .setOperator("-")
                .setSecondInput(secInput)
                .clickBtnGo()
                .waitForFinishingCalculation()
                .getLastValueFromHistoryTable()
                .getResult()
          ,expectedRes);
    }

    @Test(dataProvider = "division-provider", dataProviderClass = DataProviderForPositiveTests.class)
    public void divisionTest(String firstInput, String secInput, String expectedRes){
        Assert.assertEquals(mainPageObj
                .setFirstInput(firstInput)
                .setOperator("/")
                .setSecondInput(secInput)
                .clickBtnGo()
                .waitForFinishingCalculation()
                .getLastValueFromHistoryTable()
                .getResult()
        , expectedRes);
    }

    @Test(dataProvider = "multiplication-provider", dataProviderClass = DataProviderForPositiveTests.class)
    public void multiplicationTest(String firstInput, String secInput, String expectedRes){
        Assert.assertEquals(mainPageObj
                .setFirstInput(firstInput)
                .setOperator("*")
                .setSecondInput(secInput)
                .clickBtnGo()
                .waitForFinishingCalculation()
                .getLastValueFromHistoryTable()
                .getResult()
        ,expectedRes);
    }

    @Test(dataProvider = "percentage-provider", dataProviderClass = DataProviderForPositiveTests.class)
    public void percentageTest(String firstInput, String secInput, String expectedRes){
        Assert.assertEquals(mainPageObj
                .setFirstInput(firstInput)
                .setOperator("%")
                .setSecondInput(secInput)
                .clickBtnGo()
                .waitForFinishingCalculation()
                .getLastValueFromHistoryTable()
                .getResult()
                , expectedRes);
    }
}
