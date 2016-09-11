import data.provider.DataProviderForNegativeTests;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Andrii Shershnov on 11.09.2016.
 */
public class NegativeTests extends BaseTest{
    @Test(dataProvider = "addition-provider", dataProviderClass = DataProviderForNegativeTests.class)
    public void additionTest(String firstInput, String secInput, String expectedRes){
        Assert.assertEquals(mainPageObj
                .setFirstInput(firstInput)
                .setOperator("+")
                .setSecondInput(secInput)
                .clickBtnGo()
                .waitForFinishingCalculation()
                .getLastValueFromHistoryTable()
                .getResult()
                , expectedRes);
    }

    @Test(dataProvider = "subtraction-provider", dataProviderClass = DataProviderForNegativeTests.class)
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

    @Test(dataProvider = "division-provider", dataProviderClass = DataProviderForNegativeTests.class)
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

    @Test(dataProvider = "multiplication-provider", dataProviderClass = DataProviderForNegativeTests.class)
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

    @Test(dataProvider = "percentage-provider", dataProviderClass = DataProviderForNegativeTests.class)
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
