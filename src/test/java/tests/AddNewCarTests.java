package tests;

import manager.DataProviderCar;
import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase {

    @BeforeClass
    public void preCondition(){
        if (!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("ssa@gmail.com").setPassword("Ssa12345$"));
            logger.info("Before class logged in account with data ---> email: 'ssa@gmail.com', password: 'Ssa12345$'");
        }
    }
    @Test(dataProvider = "addDataNewCarSuccess", dataProviderClass = DataProviderCar.class)
    public void addNewCarSuccessAll(Car car) {
        logger.info("Test data ---> "+car.toString());
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().attachPhoto("C:\\Users\\honor\\QA37\\QA37_IlCarro\\photo.jpg");
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().getMessage().contains("added successful"));
        logger.info("Assert check is Element with text 'added successful' present");
        Assert.assertEquals(app.getHelperCar().getMessage(), car.getManufacture() + " " + car.getModel() + " added successful");
    }

    @Test
    public void addNewCarSuccess() {
        int i = new Random().nextInt(1000) + 1000;
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Nissan")
                .model("A2")
                .year("2004")
                .fuel("Petrol")
                .seats(5)
                .carClass("C")
                .carRegNumber("198-72613-" + i)
                .price(50)
                .build();

        logger.info("Test data ---> location: 'Tel Aviv, Israel', manufacture: 'Nissan', model: 'A2', year: '2004', fuel: 'Petrol', seats: '5', carClass: 'C', carRegNumber: 198-72613-"+i+", price: '50'");
        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().getMessage().contains("added successful"));
        logger.info("Assert check is Element with text 'added successful' present");
        Assert.assertEquals(app.getHelperCar().getMessage(), car.getManufacture() + " " + car.getModel() + " added successful");
    }

    @AfterMethod
    public void postCondition(){
        app.getHelperCar().returnHome();
        logger.info("Assert check is home page displayed");
    }
}
