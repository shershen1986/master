package data.provider;

import org.testng.annotations.DataProvider;

/**
 * Created by Andrii Shershnov on 11.09.2016.
 */
public class DataProviderForNegativeTests {
    @DataProvider(name = "addition-provider")
    public static Object[][] additionTestProvider() {
        return new Object[][]{
                {"", "", "NaN"},
                {"", "-1", "NaN"},
                {"--1", "-1", "NaN"},
                {"-1", "--1", "NaN"},
                {"", "1", "NaN"},
                {"1", "", "NaN"},
                {"text", "text", "NaN"},
                {"text", "@#$#%%^^@#!@!", "NaN"},
        };
    }

    @DataProvider(name = "subtraction-provider")
    public static Object[][] subtractionTestProvider() {
        return new Object[][]{
                {"", "", "NaN"},
                {"", "-1", "NaN"},
                {"--1", "-1", "NaN"},
                {"-1", "--1", "NaN"},
                {"", "1", "NaN"},
                {"1", "", "NaN"},
                {"text", "text", "NaN"},
                {"text", "@#$#%%^^@#!@!", "NaN"},
        };
    }

    @DataProvider(name = "division-provider")
    public static Object[][] divisionTestProvider() {
        return new Object[][]{
                {"1", "0", "Infinity"},
                {"1", "-0", "Infinity"},
                {"0", "0", "NaN"},
                {"gsd", "0", "NaN"},
        };
    }

    @DataProvider(name = "multiplication-provider")
    public static Object[][] multiplicationTestProvider() {
        return new Object[][]{
                {"", "", "NaN"},
                {"-a", "1", "NaN"},
                {"%$#%$%#%$", "3", "NaN"},
                {"-1", "-a", "NaN"}
        };
    }

    @DataProvider(name = "percentage-provider")
    public static Object[][] percentageTestProvider() {
        return new Object[][]{
                {"", "", "NaN"},
                {"15", "", "NaN"},
                {"", "100", "NaN"},
                {"-0", "100", "NaN"},
                {"sfsdf", "100", "NaN"}
        };
    }
}
