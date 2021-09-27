package pages.wms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.CommonPage;

public class SiteTypeSectionPage extends CommonPage {

	public SiteTypeSectionPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}

	/************ locators ***************/
	
	@FindBy(xpath = "//button[normalize-space()='Add Site Type']")
	WebElement addSiteType_by;
	
	@FindBy(css = "input[placeholder='Search...']")
	WebElement searchBox_by;
	
	@FindBy(css = "span[aria-label='search']")
	WebElement searchIcon_by;
	
	@FindBy(css = "span.anticon-edit")
	WebElement editButton_by;
	
	@FindBy(css = "span.anticon-delete")
	WebElement deleteButton_by;
	
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement confirmation_by;
	
	/************ actions ****************/
	
	public AddSiteType clickAddSiteType() {
		click(addSiteType_by);
		return new AddSiteType(driver);
	}
	
	public SiteTypeSectionPage clickSearchTextAs(String text) {
		logStep("Searching data using seach text as "+text);
		sendKeys(searchBox_by, text);
		clickUsingJSExecutor(searchIcon_by);
		hardWait(5000);
		return new SiteTypeSectionPage(driver);
	}
	
	public AddSiteType clickEditSiteType() {
		click(editButton_by);
		return new AddSiteType(driver);
	}
	
	public SiteTypeSectionPage clickDeleteSiteType() {
		click(deleteButton_by);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(confirmation_by));
		clickUsingJSExecutor(confirmation_by);
		return new SiteTypeSectionPage(driver);
	}
	
	/************ accessors **************/
	
	public boolean isDetailDisplayed(String detail) {
		List<WebElement> orders = driver.findElements(By.cssSelector("td.ant-table-cell"));
		for (WebElement listItem : orders)
			if (listItem.getText().contains(detail)) {
				break;
			}
		return true;
	}

}
