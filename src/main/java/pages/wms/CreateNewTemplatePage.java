package pages.wms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import framework.CommonPage;

public class CreateNewTemplatePage extends CommonPage {

	public CreateNewTemplatePage(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}

	/************ locators ***************/
	
	@FindBy(css = "input.ant-input")
	WebElement templateName_by;
	
	@FindBy(css = "input.ant-checkbox-input")
	WebElement checkBoxes_by;
	
	/************ actions ****************/
	public void setTemplateName(String templateName) {
		sendKeys(templateName_by, templateName);
	}
	
	public void selectAllPermissionsOnPage(String pageNumber) {
		clickLink(pageNumber);
		List<WebElement> permissions = driver.findElements(By.cssSelector("input.ant-checkbox-input"));
		for (WebElement listItem : permissions) {
			clickUsingJSExecutor(listItem);
		}
	}
	/************ accessors **************/
	
	/************ validations ************/
}
