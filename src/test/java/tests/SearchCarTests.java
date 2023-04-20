package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase{

    @Test
    public void searchCurrentMonthSuccess() {
        app.getHelperCar().searchCurrentMonth("Tel Aviv, Israel", "4/20/2023", "4/25/2023");
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

    @Test
    public void searchCurrentYearSuccess() {
        app.getHelperCar().searchCurrentYear("Tel Aviv, Israel", "6/27/2023", "10/28/2023");
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

    @Test
    public void searchAnyPeriodSuccess() {
        //app.getHelperCar().searchAnyPeriod("Tel Aviv, Israel", "1/27/2023", "2/28/2024");
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }
}
