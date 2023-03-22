package tests;

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
        }
        else app.getHelperUser().refresh();
    }

    @Test
    public void loginSuccess(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ssa@gmail.com", "Ssa12345$");
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
    }

    @Test
    public void loginSuccessModel(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ssa@gmail.com", "Ssa12345$");
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(), "Logged in success");
    }

    @Test
    public void loginWrongEmail(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ssagmail.com", "Ssa12345$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().notClickable());

    }

    @Test
    public void loginWrongEmailEmpty(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("", "Ssa12345$");
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().errorMessageForm(), "Email is required");// in code " Email is required "???
    }

    @Test
    public void loginWrongPassword(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ssa@gmail.com", "Ssa");
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
    }

    @Test
    public void loginWrongPasswordEmpty(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("ssa@gmail.com", "");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().notClickable());
    }

    @Test
    public void loginUnregisteredUser(){
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("abc@gmail.com", "Abc12345$");
        app.getHelperUser().submitLogin();

        Assert.assertEquals(app.getHelperUser().getMessage(), "\"Login or Password incorrect\"");
    }


    @AfterMethod
    public void postCondition(){
        if (app.getHelperUser().isPopup()) {
            app.getHelperUser().closeWindow();}
    }

}
