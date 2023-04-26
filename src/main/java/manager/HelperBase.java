package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.plaf.PanelUI;
import java.time.Duration;
import java.util.List;

public class HelperBase {
    Logger logger = LoggerFactory.getLogger(HelperBase.class);

    WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator){
        WebElement element = wd.findElement(locator);
        element.click();
    }

    public void type(By locator, String text){
        WebElement element = wd.findElement(locator);
        element.click();
        element.clear();
        if (text != null)
        {
            element.sendKeys(text);
        }
    }

    public void pause(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isElementPresent(By locator){
        return wd.findElements(locator).size()>0;
    }

    public void back(){
        wd.navigate().back();
    }

    public void clearNew(WebElement element)
    {
        element.sendKeys(" ");
        element.sendKeys(Keys.BACK_SPACE);
    }

    public void submit() {
        click(By.xpath("//button[@type='submit']"));
    }

    public String getMessage() {
        //wait
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container"))));
        //pause(2000);
        return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();
    }

    public void clearTextBox(By locator){
        WebElement element = wd.findElement(locator);
        String os = System.getProperty("os.name");
        System.out.println(os);
        if(os.startsWith("Win")){
            element.sendKeys(Keys.CONTROL, "a");
        }else {
            element.sendKeys(Keys.COMMAND, "a");
        }
        element.sendKeys(Keys.DELETE);
    }

    public boolean notClickable(){
        boolean res =  isElementPresent(By.xpath("//button[@disabled]"));
        WebElement element = wd.findElement(By.cssSelector("button[type = 'submit']"));
        boolean result = element.isEnabled();
        return res && !result;
    }

    public String getErrorText() {
        return wd.findElement(By.cssSelector(".error")).getText();
    }

    public boolean errorPresent(){
        return isElementPresent(By.className("error"));
    }
}


