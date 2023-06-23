package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.WebTablesPage;

public class WebTablesTest extends BasicTest{
    private final static String FIRST_NAME = "Auto";
    private final static String LAST_NAME = "Test";
    private final static String EMAIL = "autotest@test.com";
    private final static String AGE = "31";
    private final static String SALARY = "3000";
    private final static String DEPARTMENT = "AQA";
    private final static String DEPARTMENT_MODIFIED = "AQAModified";

    @Test
    @Description("The test is checking positive case for adding a record")
    public void addRecordToRegistrationFormTest(){
        WebTablesPage select = new WebTablesPage(driver);
        Integer initNumber = select.getTableEmptyRowsNumber();
        System.out.println(initNumber);
        select.clickAddBtn();
        select.fillInRegistrationForm(FIRST_NAME, LAST_NAME, EMAIL, AGE, SALARY, DEPARTMENT);
        Integer actNumber = select.getTableEmptyRowsNumber();
        System.out.println(actNumber);
        Assert.assertTrue(actNumber<initNumber, "The new record is not added");
    }

    @Test
    @Description("The test is checking positive case for searching the added record")
    public void getAddedRecordTest(){
        WebTablesPage select = new WebTablesPage(driver);
        select.clickAddBtn();
        select.fillInRegistrationForm(FIRST_NAME, LAST_NAME, EMAIL, AGE, SALARY, DEPARTMENT);
        String actRecord = select.getAddedElement();
        Assert.assertEquals(actRecord, DEPARTMENT, "The record is wrong");
    }

    @Test
    @Description("The test is checking positive case for updating the added record")
    public void editAddedRecordTest(){
        WebTablesPage select = new WebTablesPage(driver);
        select.clickAddBtn();
        select.fillInRegistrationForm(FIRST_NAME, LAST_NAME, EMAIL, AGE, SALARY, DEPARTMENT);
        select.editRegistrationForm(DEPARTMENT_MODIFIED);
        String actRecord = select.getModifiedElement();
        Assert.assertEquals(actRecord, DEPARTMENT_MODIFIED, "The record is wrong");
    }

    @Test()
    @Description("The test is checking positive case for deletion of the added modified record")
    public void deleteAddedRecordTest(){
        WebTablesPage select = new WebTablesPage(driver);
        Integer initNumber = select.getTableEmptyRowsNumber();
        System.out.println(initNumber);
        select.clickAddBtn();
        select.fillInRegistrationForm(FIRST_NAME, LAST_NAME, EMAIL, AGE, SALARY, DEPARTMENT);
        select.editRegistrationForm(DEPARTMENT_MODIFIED);
        select.deleteRegistrationForm();
        Integer actNumber = select.getTableEmptyRowsNumber();
        System.out.println(actNumber);
        Assert.assertTrue(initNumber == actNumber, "The new record is not deleted");
    }
}
