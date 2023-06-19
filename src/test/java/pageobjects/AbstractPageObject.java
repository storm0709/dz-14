package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractPageObject {
    private final static int DURATION_FOR_WAIT=4;
    protected WebDriver driver;

    public AbstractPageObject(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getElement(By by,int waitForSeconds){
        return new WebDriverWait(driver, Duration.ofSeconds(waitForSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public WebElement getElement(By by){
        return new WebDriverWait(driver, Duration.ofSeconds(DURATION_FOR_WAIT))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> getElements(By by,int waitForSeconds){
        return new WebDriverWait(driver, Duration.ofSeconds(waitForSeconds))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }
    public List<WebElement> getElements(By by){
        return new WebDriverWait(driver, Duration.ofSeconds(DURATION_FOR_WAIT))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void waitTillAppears(By by, int waitForSeconds){
        new WebDriverWait(driver, Duration.ofSeconds(waitForSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
    public void waitTillAppears(By by){
        new WebDriverWait(driver, Duration.ofSeconds(DURATION_FOR_WAIT))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitTillDisappears(By by,int waitForSeconds){
        new WebDriverWait(driver, Duration.ofSeconds(waitForSeconds))
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public void waitTillDisappears(By by){
        new WebDriverWait(driver, Duration.ofSeconds(DURATION_FOR_WAIT))
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void adsScrollHandler(By by){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement adsHandling = driver.findElement(by);
        js.executeScript("arguments[0].scrollIntoView();", adsHandling);
    }

    public void fillInInputField (By by, String input){
        getElement(by).sendKeys(input);
    }
}
