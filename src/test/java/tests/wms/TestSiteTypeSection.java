package tests.wms;

import org.testng.annotations.Test;
import baseTestScripts.TestData;
import baseTestScripts.TestNGBaseTest;
import pages.wms.AddSiteType;
import pages.wms.HomePage;
import pages.wms.SiteTypeSectionPage;
import pages.wms.SubMenuSectionPage;
import pages.wms.Tier1DashBoardPage;
import utils.GeneratorUtils;

public class TestSiteTypeSection extends TestNGBaseTest {

	@Test()
	public void testCreateEditAndDeleteSiteType() throws Exception {
		String testNumber = "TC_12";
		String coverage = "Verifies that Tier1 User can create, edit and delete site type from site type section.";
		String createDate = "27/09/2021";
		logTestDocumentations(testNumber, coverage, createDate);
		
		HomePage homePage = navigateToWMSWebsite(false);
		assertTrue(homePage.isPageTitleDisplayed("Login"), "Login Page is Displayed");
		
		logStep("Enter Valid Username, Password and Sign In");
		homePage.setEmail(TestData.email);
		homePage.setPassword(TestData.password);
		Tier1DashBoardPage tier1DashBoardPage = homePage.clickSignIn();
		assertTrue(tier1DashBoardPage.getWelcomeMessage().contains("Welcome Automation User!"), "Welcome Automation User! - Welcome Message is Displayed");
		
		logStep("Go to SITE TYPE Section");
		SubMenuSectionPage subMenuSectionPage = tier1DashBoardPage.clickOnSubMenuSection("SITE TYPE", "Site Type List");
		SiteTypeSectionPage siteTypeSectionPage = subMenuSectionPage.getSiteTypeSection();
		assertTrue(siteTypeSectionPage.isSectionPageTitleDisplayed("Site Type List"), "Site Type List is Displayed");
		
		logStep("Add Site Type");
		AddSiteType addSiteType = siteTypeSectionPage.clickAddSiteType();
		assertTrue(addSiteType.isSectionPageTitleDisplayed("CREATE NEW SITE"), "CREATE NEW SITE Page is Displayed");
		 
		String alertMessage = "Please enter Site Type!";
		
		logStep("Create Site Type with Blank Data");
		addSiteType.clickSubmit();
		assertTrue(homePage.getAlertMessages(alertMessage), alertMessage+" - Message is Displayed");
		
		addSiteType.clickCancel();
		assertTrue(siteTypeSectionPage.isSectionPageTitleDisplayed("Site Type List"), "Site Type List is Displayed");
		
		String siteType = GeneratorUtils.generateUniqueId("SiteType");
		
		logStep("Create Site Type with Valid Data");
		addSiteType = siteTypeSectionPage.clickAddSiteType();
		addSiteType.setSiteTypeName(siteType);
		addSiteType.clickSubmit();
		assertTrue(siteTypeSectionPage.isSectionPageTitleDisplayed("Site Type List"), "Site Type List is Displayed");
		
		logStep("Validate newly created company");
		siteTypeSectionPage.clickSearchTextAs(siteType);
		assertTrue(siteTypeSectionPage.isDetailDisplayed(siteType), siteType+" is Displayed");
		assertTrue(siteTypeSectionPage.isDetailDisplayed(TestData.user_fullname), TestData.user_fullname+" is Displayed");
		
		logStep("Edit Site Type");
		addSiteType = siteTypeSectionPage.clickEditSiteType();
		
		String editSiteType = GeneratorUtils.generateUniqueId("Edited");
		
		addSiteType.setSiteTypeName(editSiteType);
		addSiteType.clickSubmit();
		
		logStep("Validate newly created Site Type");
		siteTypeSectionPage.clickSearchTextAs(editSiteType);
		assertTrue(siteTypeSectionPage.isDetailDisplayed(editSiteType), editSiteType+" is Displayed");
		assertTrue(siteTypeSectionPage.isDetailDisplayed(TestData.user_fullname), TestData.user_fullname+" is Displayed");
		
		logStep("Delete newly created Site Type");
		siteTypeSectionPage.clickDeleteSiteType();
		siteTypeSectionPage.refreshPage();
		siteTypeSectionPage.clickSearchTextAs(editSiteType);
		assertTrue(siteTypeSectionPage.isNoDataFoundMessageDisplayed(), "No Data Found Message is Displayed");
		siteTypeSectionPage.refreshPage();
		siteTypeSectionPage.clickSearchTextAs(siteType);
		assertTrue(siteTypeSectionPage.isNoDataFoundMessageDisplayed(), "No Data Found Message is Displayed");
		closeBrowser();
	}
}
