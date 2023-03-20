package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){
        click(By.xpath("//*[text()='Log in']"));
    }

    public void fillLoginForm(String email, String password){
        type(By.cssSelector("#email"), email);
        type(By.id("password"), password);
    }

    public void submitYalla() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void submitOk() {
        click(By.xpath("//button[text()='Ok']"));
    }

    public boolean isLogged() {
        return isElementPresent();

    }

    public void logout(){
        click(By.xpath("//a[text()=' Logout ']"));
    }
}
