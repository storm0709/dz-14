package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ElementsPage;

public class ButtonsTest extends BasicTest{
    @Test
    @Description("The test is checking positive case for clicking on the ClickMe button")
    public void clickMeTest(){
        String messageExpected = "You have done a dynamic click";
        ElementsPage select = new ElementsPage(driver);
        select.clickButtons();
        select.clickOnClickMe();
        String messageActual = select.getMessage();
        Assert.assertEquals(messageActual, messageExpected, "Wrong action message");
        System.out.println("The test passed. Ads was hacked by JS scrolling");
    }
}
