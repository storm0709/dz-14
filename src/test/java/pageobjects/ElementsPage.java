package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsPage extends AbstractPageObject{
    private final By elements = By.xpath("(//*[@class='header-wrapper'])[1]");
    private final By radioBtn = By.xpath("(//*[@id='item-2'])[1]");
    private final By buttons = By.xpath("(//*[@id='item-4'])[1]");
    private final By clickMe = By.xpath("(//*[@class='mt-4'])[2]/button");
    private final By message = By.xpath("//*[@id=\"dynamicClickMessage\"]");
    private final By widgets = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[4]/span/div");

    public ElementsPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/elements");
    }

    @Step("The user clicks on the Buttons element")
    public void clickButtons(){
        adsScrollHandler(widgets);
        getElement(buttons, 10).click();
    }

    @Step("The user clicks on the ClickMe button")
    public void clickOnClickMe(){
        getElement(clickMe).click();
    }

    @Step("Getting message after clicking on the ClickMe button")
    public String getMessage(){
       return getElement(message).getText();
    }
}
