package tests;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
            logger.info("Before method finish logout");
        }
        else app.getHelperUser().refresh();
    }

    @Test
    public void loginSuccess1(){
        logger.info("Test data from object ---> email: 'ssa@gmail.com' & password: 'Ssa12345$'");
        User user = new User().setEmail("ssa@gmail.com").setPassword("Ssa12345$");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        logger.info("Assert check is Element present with text 'Logged in success'");
    }

    @Test
    public void loginSuccess(){
        logger.info("Start test name 'loginSuccess'");
        logger.info("Test data ---> email: 'ssa@gmail.com' & password: 'Ssa12345$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ssa@gmail.com", "Ssa12345$");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        logger.info("Assert check is Element present with text 'Logged in success'");
    }

    @Test
    public void loginSuccessModel(){
        logger.info("Test data ---> email: 'ssa@gmail.com' & password: 'Ssa12345$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ssa@gmail.com", "Ssa12345$");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
        logger.info("Assert check is Element present with text 'Logged in success'");
    }

    @Test
    public void loginWrongEmail(){
        logger.info("Test data ---> email: 'ssagmail.com' & password: 'Ssa12345$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ssagmail.com", "Ssa12345$");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "It'snot look like email");
        logger.info("Assert check is Error present with text 'It'snot look like email'");
        Assert.assertTrue(app.getHelperUser().notClickable());
        logger.info("Assert check is Element button 'Yalla' not clickable");

    }

    @Test
    public void loginWrongEmailEmpty(){
        logger.info("Test data ---> email: '' & password: 'Ssa12345$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("", "Ssa12345$");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(), "Email is required");// in code " Email is required "???
        logger.info("Assert check is Error present with text 'Email is required'");
    }

    @Test
    public void loginWrongPassword(){
        logger.info("Test data ---> email: 'ssa@gmail.com' & password: 'Ssa'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ssa@gmail.com", "Ssa");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        logger.info("Assert check is Error present with text '\"Login or Password incorrect\"'");
    }

    @Test
    public void loginWrongPasswordEmpty(){
        logger.info("Test data ---> email: 'ssa@gmail.com' & password: ''");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ssa@gmail.com", "");
        app.getHelperUser().submit();

        Assert.assertTrue(app.getHelperUser().notClickable());
        logger.info("Assert check is Element button 'Yalla' not clickable");
    }

    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data ---> email: 'abc@gmail.com' & password: 'Abc12345$'");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("abc@gmail.com", "Abc12345$");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
        logger.info("Assert check is Error present with text '\"Login or Password incorrect\"'");
    }


    @AfterMethod
    public void postCondition(){
        if (app.getHelperUser().isPopup()) {
            app.getHelperUser().closeWindow();
        logger.info("The window is closed");
        }
    }

}
