package pages.wms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import framework.CommonPage;

public class AddManagingComany extends CommonPage {

	public AddManagingComany(RemoteWebDriver webDriver) {
		super(webDriver);
		waituntilPageLoads();
	}
	
	/************ locators ***************/
	
	@FindBy(id = "managing_company_name")
	WebElement managingCompanyName_by;
	
	/************ actions ***************/
	
	public void setManagingCompanyName(String companyName) {
		sendKeys(managingCompanyName_by, companyName);
	}
}
