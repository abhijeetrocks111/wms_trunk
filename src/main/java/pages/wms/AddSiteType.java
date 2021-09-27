package pages.wms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import framework.CommonPage;

public class AddSiteType extends CommonPage {

	public AddSiteType(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}

	/************ locators ***************/
	
	@FindBy(id = "site_type")
	WebElement siteTypeName_by;
	
	/************ actions ***************/
	
	public void setSiteTypeName(String siteTypeName) {
		siteTypeName_by.clear();
		sendKeys(siteTypeName_by, siteTypeName);
	}

}
