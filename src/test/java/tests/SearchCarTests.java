package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase{

    @Test
    public void searchCurrentMonthSuccess() {
        app.getHelperCar().searchCurrentMonth("Tel Aviv, Israel", "5/1/2023", "5/5/2023");
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
        app.getHelperCar().searchAnyPeriod("Tel Aviv, Israel", "10/27/2023", "4/20/2024");
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());
    }

    @Test
    public void negativeSearchMy(){
        app.getHelperCar().searchNotValidPeriod("Tel Aviv, Israel", "1/10/2025", "10/10/2025");

        Assert.assertTrue(app.getHelperCar().notClickable());
        Assert.assertTrue(app.getHelperCar().errorPresent());

    }

    @Test
    public void negativeSearch(){
        app.getHelperCar().searchNotValidPeriod("Tel Aviv, Israel", "1/10/2023", "10/10/2023");

        Assert.assertTrue(app.getHelperCar().isErrorDisplayed("You can't pick date before today"));

    }

    @BeforeMethod
    public void postCondition(){
        app.getHelperCar().navigateByLogo();
    }
}
