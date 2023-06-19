package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTablesPage extends AbstractPageObject{
    private final By addBtn = By.xpath("//*[@id=\"addNewRecordButton\"]");
    private final By title = By.xpath("//*[@id=\"registration-form-modal\"]");
    private final By firstNameInputField = By.xpath("//*[@id=\"firstName\"]");
    private final By lastNameInputField = By.xpath("//*[@id=\"lastName\"]");
    private final By emailInputField = By.xpath("//*[@id=\"userEmail\"]");
    private final By ageInputField = By.xpath("//*[@id=\"age\"]");
    private final By salaryInputField = By.xpath("//*[@id=\"salary\"]");
    private final By departmentInputField = By.xpath("//*[@id=\"department\"]");
    private final By submitBtn = By.xpath("//*[@id=\"submit\"]");
    private final By tableEmptyRows = By.xpath("//*[contains(@class, 'rt-tr -padRow')]");
    private final By addedRow = By.xpath("//*[contains(text(), 'AQA')]");
    private final By editBtnOfAddedElement = By.xpath("//*[contains(text(), 'AQA')]/following::div//*[contains(@id, 'edit')]");
    private final By modifiedRow = By.xpath("//*[contains(text(), 'AQAModified')]");
    private final By uploadAndDownload = By.xpath("(//*[@id=\"item-6\"])[1]");
    private final By deleteBtnOfAddedElement = By.xpath("//*[contains(text(), 'AQAModified')]/following::div//*[contains(@id, 'delete')]");
    public WebTablesPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/webtables");
    }

    @Step("The user clicks on the Add button")
    public void clickAddBtn(){
        getElement(addBtn).click();
    }
    public String getAddBtn(){
        return getElement(addBtn).getText();
    }

    public String getFormTitle(){
        return getElement(title).getText();
    }

    @Step("The user fills in the Registration form with [{0},{1}, {2}, {3}, {4}, {5}]")
    public WebTablesPage fillInRegistrationForm(String firstName, String lastName, String email, String age, String salary, String department){
        fillInInputField(firstNameInputField, firstName);
        fillInInputField(lastNameInputField, lastName);
        fillInInputField(emailInputField, email);
        fillInInputField(ageInputField, age);
        fillInInputField(salaryInputField, salary);
        fillInInputField(departmentInputField, department);
        getElement(submitBtn).click();
        return this;
    }

    @Step("Getting numper of empty records")
    public int getTableEmptyRowsNumber(){
        return getElements(tableEmptyRows).size();
    }

    @Step("Getting added row")
    public String getAddedElement(){
        adsScrollHandler(uploadAndDownload);
        return getElement(addedRow,10).getText();
    }
    @Step("The user modified the Department with [{0}]")
    public WebTablesPage editRegistrationForm(String departmentModified){
        adsScrollHandler(uploadAndDownload);
        getElement(editBtnOfAddedElement,10).click();
        getElement(departmentInputField).clear();
        fillInInputField(departmentInputField, departmentModified);
        getElement(submitBtn).click();
        return this;
    }
    @Step("Getting modified record")
    public String getModifiedElement(){
        return getElement(modifiedRow).getText();
    }
    @Step("The user deletes the added modified record")
    public WebTablesPage deleteRegistrationForm(){
        getElement(deleteBtnOfAddedElement,10).click();
        return this;
    }
}
