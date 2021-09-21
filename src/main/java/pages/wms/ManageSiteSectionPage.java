package pages.wms;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManageSiteSectionPage extends SubMenuSectionPage {

	public ManageSiteSectionPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}
	
	/************ locators ***************/
	
	@FindBy(xpath = "//button[normalize-space()='Create New Site']")
	WebElement createNewSite_by;
	
	@FindBy(xpath = "//button[normalize-space()='Deleted Sites']")
	WebElement deletedSitesButton_by;
	
	@FindBy(xpath = "//button[normalize-space()='Archived Sites']")
	WebElement archievedSitesButton_by;
	
	@FindBy(css = "input[placeholder='Search...']")
	WebElement searchBox_by;
	
	@FindBy(css = "span[aria-label='search']")
	WebElement searchIcon_by;
	
	@FindBy(css = "span.anticon-edit")
	WebElement editButton_by;
	
	@FindBy(css = "span.anticon-delete")
	WebElement deleteButton_by;
	
	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement deleteUserConfirmation_by;
	
	@FindBy(xpath = "//button[@role='switch']")
	WebElement lockUnlockButton_by;
	
	@FindBy(css = "td span.anticon.anticon-team svg")
	WebElement teamButton_by;
	
	/************ actions ****************/
	
	public CreateNewSitePage clickCreateNewSite() {
		click(createNewSite_by);
		return new CreateNewSitePage(driver);
	}
	
	public CreateNewSitePage clickEditSite() {
		click(editButton_by);
		return new CreateNewSitePage(driver);
	}
	
	public ManageSiteSectionPage clickDeletedSitesButton() {
		click(deletedSitesButton_by);
		return new ManageSiteSectionPage(driver);
	}
	
	public ManageSiteSectionPage clickArchieveSitesButton() {
		clickUsingJSExecutor(archievedSitesButton_by);
		return new ManageSiteSectionPage(driver);
	}
	
	public ManageSiteSectionPage clickDeleteSite() {
		click(deleteButton_by);
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(deleteUserConfirmation_by));
		clickUsingJSExecutor(deleteUserConfirmation_by);
		return new ManageSiteSectionPage(driver);
	}
	
	public ManageSiteSectionPage clickSearchTextAs(String text) {
		logStep("Searching User using seach text as "+text);
		sendKeys(searchBox_by, text);
		clickUsingJSExecutor(searchIcon_by);
		hardWait(5000);
		return new ManageSiteSectionPage(driver);
	}
	
	public void clickLockUnlockButton() {
		clickUsingJSExecutor(lockUnlockButton_by);
	}
	
	public SiteTeamPage clickTeamIcon() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(6000,50)");
		click(teamButton_by);
		return new SiteTeamPage(driver);
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
	
	/************ validations ************/
}
