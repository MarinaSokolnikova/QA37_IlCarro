package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        app.getHelperUser().pause(3000);
        if(app.getHelperUser().isLogged()){
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(2000);
        System.out.println(i);

        System.out.println(System.currentTimeMillis());
        int z = (int)System.currentTimeMillis()/1000;
        User user = new User().setFirstName("Lisa").setLastName("Snow").setEmail("snow"+i+"@gmail.com").setPassword("Snow12345$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(), "You are logged in success");
    }

    @Test
    public void registrationWrongName(){
        User user = new User().setFirstName("").setLastName("Clod").setEmail("clod@gmail.com").setPassword("Clod12345$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Name is required");// in code " Name is required "???
        Assert.assertTrue(app.getHelperUser().notClickable());
    }

    @Test
    public void registrationWrongLastName(){
        User user = new User().setFirstName("Jan").setLastName("").setEmail("clod@gmail.com").setPassword("Clod12345$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Last name is required");
        Assert.assertTrue(app.getHelperUser().notClickable());
    }

    @Test
    public void registrationWrongEmail(){
        User user = new User().setFirstName("Jan").setLastName("Clod").setEmail("clodgmail.com").setPassword("Clod12345$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Wrong email format\n" +
                "Wrong email format");
        Assert.assertTrue(app.getHelperUser().notClickable());
    }

    @Test
    public void registrationWrongPassword(){
        User user = new User().setFirstName("Jan").setLastName("Clod").setEmail("clod@gmail.com").setPassword("Clod12$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(), "Password must contain minimum 8 symbols\n" +
                "Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
        Assert.assertTrue(app.getHelperUser().notClickable());
    }

    @Test
    public void registrationCheckboxUnchecked(){
        User user = new User().setFirstName("Jan").setLastName("Clod").setEmail("clod@gmail.com").setPassword("Clod1234$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submit();
        Assert.assertTrue(app.getHelperUser().notClickable());
    }

    @Test
    public void registrationRegisteredUser(){
        User user = new User().setFirstName("Jan").setLastName("Clod").setEmail("ssa@gmail.com").setPassword("Ssa12345$");
        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicyXY();
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getMessage(), "\"User already exists\"");
    }

    @AfterMethod
    public void postCondition(){
        if (app.getHelperUser().isPopup()) {
            app.getHelperUser().closeWindow();}
        app.getHelperUser().back();
    }
}
