package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){
        click(By.xpath("//*[text()=' Log in ']"));
    }

    public void fillLoginForm(String email, String password){
        type(By.cssSelector("#email"), email);
        type(By.id("password"), password);
    }

    public void fillLoginForm(User user){
        type(By.cssSelector("#email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }



    public void closeWindow() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public void logout(){
        click(By.xpath("//a[text()=' Logout ']"));
    }



    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public boolean isPopup() {
        return isElementPresent(By.cssSelector(".dialog-container"));
    }

//    public String errorMessageForm(){
//        return wd.findElement(By.cssSelector(".error")).getText();
//    }








    //**************Registration*************
    public void openRegistrationForm() {
        click(By.xpath("//a[text()=' Sign up ']"));
    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"), user.getFirstName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
    }

    public void checkPolicy() {
        //click(By.id("terms-of-use"));
        click(By.cssSelector("label[for='terms-of-use']"));
        //document.querySelector('#terms-of-use').click();
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("document.querySelector('#terms-of-use').click();");
    }


    public void checkPolicyXY(){
        if (wd.findElement(By.id("terms-of-use")).isSelected()!= true){
        Actions actions = new Actions(wd);
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rect = label.getRect();
        int w = rect.getWidth();

        int xOffSet = -w/2;
        actions.moveToElement(label, xOffSet, 0).click().release().perform();
    }
    }

    public void refresh() {
        wd.navigate().refresh();
        logger.info("Refresh");
    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submit();
        closeWindow();
    }
}
