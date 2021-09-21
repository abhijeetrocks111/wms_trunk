package pages.wms;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.CommonPage;

public class CreateNewTeamPage extends CommonPage {

	public CreateNewTeamPage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}
	
	/************ locators ***************/
	
	@FindBy(id = "team_name")
	WebElement teamName_by;
	
	@FindBy(css = "div#status input[value='0']")
	WebElement activeStatus_by;
	
	@FindBy(css = "div#status input[value='1']")
	WebElement inactiveStatus_by;
	
	@FindBy(css = "div#status input[value='2']")
	WebElement suspendedStatus_by;
	
	@FindBy(id = "note")
	WebElement note_by;
	
	/************ actions ****************/
	
	public void setTeamName(String teamName) {
		sendKeys(teamName_by, teamName);
	}
	
	public void setSiteName(String siteName) {
		click(findElement(By.id("site_id")));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[title='"+siteName+"'] div[class='ant-select-item-option-content']")));
		List<WebElement> listItems = driver.findElements(By.cssSelector("div[title='"+siteName+"'] div[class='ant-select-item-option-content']"));
		for (WebElement listItem : listItems) {
			if (listItem.getText().contains(siteName)) {
				clickUsingJSExecutor(listItem);
				break;
			}
		}
	}
	
	public void setUserName(String userName) {
		click(findElement(By.id("select_user")));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[title='"+userName+"'] div[class='ant-select-item-option-content']")));
		List<WebElement> listItems = driver.findElements(By.cssSelector("div[title='"+userName+"'] div[class='ant-select-item-option-content']"));
		for (WebElement listItem : listItems) {
			if (listItem.getText().contains(userName)) {
				clickUsingJSExecutor(listItem);
				break;
			}
		}
	}
	
	public void setRole(String role) {
		click(findElement(By.id("role_id")));
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[title='"+role+"'] div[class='ant-select-item-option-content']")));
		List<WebElement> listItems = driver.findElements(By.cssSelector("div[title='"+role+"'] div[class='ant-select-item-option-content']"));
		for (WebElement listItem : listItems) {
			if (listItem.getText().contains(role)) {
				clickUsingJSExecutor(listItem);
				break;
			}
		}
	}
	
	public void setActiveStatus() {
		clickUsingJSExecutor(activeStatus_by);
	}
	
	public void setInactiveStatus() {
		clickUsingJSExecutor(inactiveStatus_by);
	}
	
	public void setSuspendedStatus() {
		clickUsingJSExecutor(suspendedStatus_by);
	}
	
	public void setNote(String note) {
		sendKeys(note_by, note);
	}

	/************ accessors **************/
	
	/************ validations ************/

}
