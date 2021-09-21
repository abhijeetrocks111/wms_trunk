package pages.wms;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import framework.CommonPage;

public class SiteTeamPage extends CommonPage {

	public SiteTeamPage(RemoteWebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	/************ locators ***************/
	
	@FindBy(xpath = "//button[normalize-space()='Create New Team']")
	WebElement createNewTeam_by;
	
	
	/************ actions ****************/
	
	public CreateNewTeamPage clickCreateNewTeam() {
		click(createNewTeam_by);
		return new CreateNewTeamPage(driver);
	}
	
	/************ accessors **************/
	
	/************ validations ************/
	
}
