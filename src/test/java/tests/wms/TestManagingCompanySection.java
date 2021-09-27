package tests.wms;

import org.testng.annotations.Test;
import baseTestScripts.TestData;
import baseTestScripts.TestNGBaseTest;
import pages.wms.AddManagingComany;
import pages.wms.HomePage;
import pages.wms.ManagingCompaniesSectionPage;
import pages.wms.SubMenuSectionPage;
import pages.wms.Tier1DashBoardPage;
import utils.GeneratorUtils;

public class TestManagingCompanySection extends TestNGBaseTest {

	@Test()
	public void testCreateEditAndDeleteManagingCompanies() throws Exception {
		String testNumber = "TC_10";
		String coverage = "Verifies that Tier1 User can create, edit and delete managing company from managing company section.";
		String createDate = "27/09/2021";
		logTestDocumentations(testNumber, coverage, createDate);
		
		HomePage homePage = navigateToWMSWebsite(false);
		assertTrue(homePage.isPageTitleDisplayed("Login"), "Login Page is Displayed");
		
		logStep("Enter Valid Username, Password and Sign In");
		homePage.setEmail(TestData.email);
		homePage.setPassword(TestData.password);
		Tier1DashBoardPage tier1DashBoardPage = homePage.clickSignIn();
		assertTrue(tier1DashBoardPage.getWelcomeMessage().contains("Welcome Automation User!"), "Welcome Automation User! - Welcome Message is Displayed");
		
		logStep("Go to Managing Companies Section");
		SubMenuSectionPage subMenuSectionPage = tier1DashBoardPage.clickOnSubMenuSection("MANAGING COMPANIES", "Managing Companies List");
		ManagingCompaniesSectionPage managingCompaniesSectionPage = subMenuSectionPage.getManaginingCompaniesSection();
		assertTrue(managingCompaniesSectionPage.isSectionPageTitleDisplayed("Managing Company List"), "Managing Company List is Displayed");
		
		logStep("Add Managing Company");
		AddManagingComany addManagingComany = managingCompaniesSectionPage.clickAddManaginingCompany();
		assertTrue(addManagingComany.isSectionPageTitleDisplayed("MANAGING COMPANY"), "MANAGING COMPANY Page is Displayed");
		 
		String alertMessage = "Please enter Company Name!";
		
		logStep("Create Managing Company with Blank Data");
		addManagingComany.clickSubmit();
		assertTrue(homePage.getAlertMessages(alertMessage), alertMessage+" - Message is Displayed");
		
		addManagingComany.clickCancel();
		assertTrue(managingCompaniesSectionPage.isSectionPageTitleDisplayed("Managing Company List"), "Managing Company List is Displayed");
		
		String companyName = GeneratorUtils.generateUniqueId("ManagingCompany");
		
		logStep("Create Managing Company with Valid Data");
		addManagingComany = managingCompaniesSectionPage.clickAddManaginingCompany();
		addManagingComany.setManagingCompanyName(companyName);
		addManagingComany.clickSubmit();
		assertTrue(managingCompaniesSectionPage.isSectionPageTitleDisplayed("Managing Company List"), "Managing Company List is Displayed");
		
		logStep("Validate newly created company");
		managingCompaniesSectionPage.clickSearchTextAs(companyName);
		assertTrue(managingCompaniesSectionPage.isDetailDisplayed(companyName), companyName+" is Displayed");
		assertTrue(managingCompaniesSectionPage.isDetailDisplayed(TestData.user_fullname), TestData.user_fullname+" is Displayed");
		
		logStep("Edit Managing Company");
		addManagingComany = managingCompaniesSectionPage.clickEditManagingCompany();
		
		String editcompanyName = GeneratorUtils.generateUniqueId("Edited_ManagingCompany");
		
		addManagingComany.setManagingCompanyName(editcompanyName);
		addManagingComany.clickSubmit();
		
		logStep("Validate newly created company");
		managingCompaniesSectionPage.clickSearchTextAs(editcompanyName);
		assertTrue(managingCompaniesSectionPage.isDetailDisplayed(editcompanyName), companyName+" is Displayed");
		assertTrue(managingCompaniesSectionPage.isDetailDisplayed(TestData.user_fullname), TestData.user_fullname+" is Displayed");
		
		logStep("Delete newly created Managing Company");
		managingCompaniesSectionPage.clickDeleteManagingCompany();
		managingCompaniesSectionPage.refreshPage();
		managingCompaniesSectionPage.clickSearchTextAs(editcompanyName);
		assertTrue(managingCompaniesSectionPage.isNoDataFoundMessageDisplayed(), "No Data Found Message is Displayed");
		managingCompaniesSectionPage.refreshPage();
		managingCompaniesSectionPage.clickSearchTextAs(companyName);
		assertTrue(managingCompaniesSectionPage.isNoDataFoundMessageDisplayed(), "No Data Found Message is Displayed");
		closeBrowser();
	}
}
