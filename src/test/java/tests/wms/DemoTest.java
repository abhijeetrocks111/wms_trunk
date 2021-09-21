//package tests.wms;
//
//import java.util.Arrays;
//import java.util.List;
//
//import org.testng.annotations.Test;
//import baseTestScripts.TestData;
//import baseTestScripts.TestNGBaseTest;
//import pages.wms.CreateNewSitePage;
//import pages.wms.CreateNewTeamPage;
//import pages.wms.CreateNewTemplatePage;
//import pages.wms.HomePage;
//import pages.wms.ManageSiteSectionPage;
//import pages.wms.PermissionSectionPage;
//import pages.wms.SiteSelectionPage;
//import pages.wms.SiteTeamPage;
//import pages.wms.SubMenuSectionPage;
//import pages.wms.Tier1DashBoardPage;
//import pages.wms.UserProfilePage;
//import utils.GeneratorUtils;
//
//public class DemoTest extends TestNGBaseTest {
//
//	@Test()
//	public void testLockUnlockArchieveSite() throws Exception {
//		String testNumber = "TC_11";
//		String coverage = "Verifies that Tier1 User can lock, unlock and archieve site from Site section.";
//		String createDate = "17/09/2021";
//		logTestDocumentations(testNumber, coverage, createDate);
//		
//		HomePage homePage = navigateToWMSWebsite(false);
//		assertTrue(homePage.isPageTitleDisplayed("Login"), "Login Page is Displayed");
//		
//		logStep("Enter Valid Username, Password and Sign In");
//		homePage.setEmail(TestData.email);
//		homePage.setPassword(TestData.password);
//		Tier1DashBoardPage tier1DashBoardPage = homePage.clickSignIn();
//		assertTrue(tier1DashBoardPage.getWelcomeMessage().contains("Welcome Automation User!"), "Welcome Automation User! - Welcome Message is Displayed");
//		
//		logStep("Go to Manage Users Section");
//		SubMenuSectionPage subMenuSectionPage = tier1DashBoardPage.clickOnSubMenuSection("Site", "Set-up Site");
//		ManageSiteSectionPage manageSiteSectionPage = subMenuSectionPage.getManageSiteSection();
//		assertTrue(manageSiteSectionPage.isSectionPageTitleDisplayed("Site List"), "Site List Page is Displayed");
//		
//		logStep("Create new site"); 
//		CreateNewSitePage createNewSitePage = manageSiteSectionPage.clickCreateNewSite();
//		assertTrue(createNewSitePage.isSectionPageTitleDisplayed("CREATE NEW SITE"), "CREATE NEW SITE Page is Displayed");
//	
//		String siteName = GeneratorUtils.generateUniqueId("Automation_Site");
//		String siteCode = GeneratorUtils.generateUniqueId("Automation_SiteCode");
//		String line1 = "Line1 Address";
//		String line2 = "Line2 Address";
//		String city = "Pune City";
//		String state = "Maharashtra State";
//		String country = "INDIA";
//		String postalCode = "412308";
//		String clientCompanyName = GeneratorUtils.generateUniqueId("CompanyName");
//		String onsiteLeadName = "OnsiteLead";
//		String onsiteLeadEmail = GeneratorUtils.generateUniqueEmail();
//		String onsiteLeadPhone = GeneratorUtils.generateUniqueMobileNumber();
//		String clientProcurementName = "ClientProcurementName";
//		String clientProcurementEmail = GeneratorUtils.generateUniqueEmail();
//		String clientProcurementPhone = GeneratorUtils.generateUniqueMobileNumber();
//		String additionalContactName = "AdditionalContactName";
//		String additionalContactEmail = GeneratorUtils.generateUniqueEmail();
//		String additionalContactPhone = GeneratorUtils.generateUniqueMobileNumber();
//		String today = GeneratorUtils.generateTodaysDate();
//		
//		logStep("Fill new site data");
//		createNewSitePage.setSiteName(siteName);
//		createNewSitePage.setSiteCode(siteCode);
//		createNewSitePage.setAddressLine1(line1);
//		createNewSitePage.setAddressLine2(line2);
//		createNewSitePage.setCity(city);
//		createNewSitePage.setState(state);
//		createNewSitePage.setCountry(country);
//		createNewSitePage.setPostalCode(postalCode);
//		createNewSitePage.setFirstAccessDate(today);
//		createNewSitePage.setExpectedEndDate(today);
//		createNewSitePage.setClientCompananyName(clientCompanyName);
//		createNewSitePage.setClientOnSiteLeadName(onsiteLeadName);
//		createNewSitePage.setClientOnSiteLeadEmail(onsiteLeadEmail);
//		createNewSitePage.setClientOnSiteLeadPhone(onsiteLeadPhone);
//		createNewSitePage.setClientProcurementContactName(clientProcurementName);
//		createNewSitePage.setClientProcurementContactEmail(clientProcurementEmail);
//		createNewSitePage.setClientProcurementContactPhone(clientProcurementPhone);
//		createNewSitePage.setAdditionalContactName(additionalContactName);
//		createNewSitePage.setAdditionalContactEmail(additionalContactEmail);
//		createNewSitePage.setAdditionalContactPhone(additionalContactPhone);
//		createNewSitePage.setAdditionalContactRole("Admin Role");
//		createNewSitePage.clickSubmit();
//
//		logStep("Validate newly created Site Details");
//		manageSiteSectionPage = new ManageSiteSectionPage(driver);
//		assertTrue(manageSiteSectionPage.isSectionPageTitleDisplayed("Site List"), "Site List Page is Displayed");
//	
//		manageSiteSectionPage.clickSearchTextAs(siteName);
//		assertTrue(manageSiteSectionPage.isDetailDisplayed(siteName), siteName+" is Displayed Successfully");
//		assertTrue(manageSiteSectionPage.isDetailDisplayed(clientCompanyName), clientCompanyName+" is Displayed Successfully");
//		assertTrue(manageSiteSectionPage.isDetailDisplayed(clientCompanyName), clientCompanyName+" is Displayed Successfully");
//		
//		logStep("Navigate to Site Team Page");
//		SiteTeamPage siteTeamPage = manageSiteSectionPage.clickTeamIcon();
//		assertTrue(siteTeamPage.isSectionPageTitleDisplayed("Site Team"), "Site Team List Page is Displayed");
//		
//		logStep("Create Team with blank data");
//		CreateNewTeamPage createNewTeamPage = siteTeamPage.clickCreateNewTeam();
//		assertTrue(createNewTeamPage.isSectionPageTitleDisplayed("CREATE SITE TEAM"), "CREATE SITE TEAM Page is Displayed");
//		
//		String alertMessage1 = "Please enter Site name!";
//		String alertMessage2 = "Please enter Team name!";
//		String alertMessage3 = "Please select the User!";
//		String alertMessage4 = "Please assign the role!";
//		String alertMessage5 = "Please select the status!";
//
//		List<String> messages = Arrays.asList(alertMessage1, alertMessage2, alertMessage3, alertMessage4, alertMessage5);
//		
//		logStep("Create Team with Blank Data");
//		createNewTeamPage.clickSubmit();
//		
//		for (String content : messages) {
//			assertTrue(createNewTeamPage.getAlertMessages(content), content+" - Message is Displayed");
//		}
//		
//		createNewTeamPage.clickCancel();
//		assertTrue(siteTeamPage.isSectionPageTitleDisplayed("Site Team"), "Site Team List Page is Displayed");
//		siteTeamPage.refreshPage();
//	
//		logStep("Create new Team"); 
//		createNewTeamPage = siteTeamPage.clickCreateNewTeam();
//		assertTrue(createNewTeamPage.isSectionPageTitleDisplayed("CREATE SITE TEAM"), "CREATE SITE TEAM Page is Displayed");
//		
//		String teamName = GeneratorUtils.generateUniqueId("AutoTeam");
//		
////		createNewTeamPage.setSiteName(siteName);
//		createNewTeamPage.setTeamName(teamName);
//		createNewTeamPage.setUserName(TestData.user_fullname);
//		createNewTeamPage.setUserName("Hard Shah");
//		createNewTeamPage.setRole("reader");
//		createNewTeamPage.setActiveStatus();
//		createNewTeamPage.clickSubmit();
//	}
//
//}