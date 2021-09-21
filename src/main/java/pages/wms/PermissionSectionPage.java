package pages.wms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import framework.CommonPage;

public class PermissionSectionPage extends CommonPage {

	public PermissionSectionPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}
	
	/************ locators ***************/
	
	@FindBy(xpath = "//button[normalize-space()='Create Template']")
	WebElement createNewTemplate_by;
	
	@FindBy(css = "input[placeholder='Search...']")
	WebElement searchBox_by;
	
	@FindBy(css = "span[aria-label='search']")
	WebElement searchIcon_by;
	
	@FindBy(css = "span.anticon-edit")
	WebElement editButton_by;
	
	@FindBy(css = "span.anticon-delete")
	WebElement deleteButton_by;
	
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement deleteConfirmation_by;
	
	/************ actions ****************/
	
	public CreateNewTemplatePage clickCreateNewTemplate() {
		click(createNewTemplate_by);
		return new CreateNewTemplatePage(driver);
	}
	
	public ManageSiteSectionPage clickSearchTextAs(String text) {
		logStep("Searching User using seach text as "+text);
		sendKeys(searchBox_by, text);
		clickUsingJSExecutor(searchIcon_by);
		hardWait(5000);
		return new ManageSiteSectionPage(driver);
	}
	
	public CreateNewTemplatePage clickEditTemplate() {
		click(editButton_by);
		return new CreateNewTemplatePage(driver);
	}
	
	/************ accessors **************/
	
	/************ validations ************/
}
