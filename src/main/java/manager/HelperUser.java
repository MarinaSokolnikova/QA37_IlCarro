package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void submitLogin() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void closeWindow() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public void logout(){
        click(By.xpath("//a[text()=' Logout ']"));
    }

    public String getMessage() {
        //wait
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
        //pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//a[text()=' Logout ']"));
    }

    public boolean isPopup() {
        return isElementPresent(By.cssSelector(".dialog-container"));
    }

    public String errorMessageForm(){
        return wd.findElement(By.cssSelector(".error")).getText();
    }

    public boolean notClickable(){
        return isElementPresent(By.xpath("//button[@disabled]"));
    }


}
