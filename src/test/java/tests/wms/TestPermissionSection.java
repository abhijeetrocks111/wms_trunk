package tests.wms;

import org.testng.annotations.Test;
import baseTestScripts.TestData;
import baseTestScripts.TestNGBaseTest;
import pages.wms.CreateNewTemplatePage;
import pages.wms.HomePage;
import pages.wms.PermissionSectionPage;
import pages.wms.SubMenuSectionPage;
import pages.wms.Tier1DashBoardPage;
import utils.GeneratorUtils;

public class TestPermissionSection extends TestNGBaseTest {

	@Test()
	public void testCreateEditAndDeleteUserFromManageUserSection() throws Exception {
		String testNumber = "TC_9";
		String coverage = "Verifies that Tier 1 user can create and edit permission template from Permission Section.";
		String createDate = "15/09/2021";
		logTestDocumentations(testNumber, coverage, createDate);
		
		HomePage homePage = navigateToWMSWebsite(false);
		assertTrue(homePage.isPageTitleDisplayed("Login"), "Login Page is Displayed");
		
		logStep("Enter Valid Username, Password and Sign In");
		homePage.setEmail(TestData.email);
		homePage.setPassword(TestData.password);
		Tier1DashBoardPage tier1DashBoardPage = homePage.clickSignIn();
		assertTrue(tier1DashBoardPage.getWelcomeMessage().contains("Welcome Automation User!"), "Welcome Automation User! - Welcome Message is Displayed");
		
		logStep("Go to Permissions Section");
		SubMenuSectionPage subMenuSectionPage = tier1DashBoardPage.clickOnSubMenuSection("Permissions", "Permission Templates");
		PermissionSectionPage permissionSectionPage = subMenuSectionPage.getPermissionSection();
		assertTrue(permissionSectionPage.isSectionPageTitleDisplayed("Permission Templates"), "Permission Template Page is Displayed");
		
		logStep("Create New Template");
		CreateNewTemplatePage createNewTemplatePage = permissionSectionPage.clickCreateNewTemplate();
		assertTrue(createNewTemplatePage.isSectionPageTitleDisplayed("CREATE NEW TEMPLATE"), "CREATE NEW TEMPLATE Page is Displayed");
		
		String alertMessage = "Please enter Site name!";
		
		logStep("Create Template with Blank Template Name");
		createNewTemplatePage.clickSubmit();
		assertTrue(createNewTemplatePage.getMessages(alertMessage), alertMessage+" - Message is Displayed");
		
		createNewTemplatePage.clickCancel();
		assertTrue(permissionSectionPage.isSectionPageTitleDisplayed("Permission Templates"), "Permission Template Page is Displayed");
		
		logStep("Create New Template");
		createNewTemplatePage = permissionSectionPage.clickCreateNewTemplate();
		assertTrue(createNewTemplatePage.isSectionPageTitleDisplayed("CREATE NEW TEMPLATE"), "CREATE NEW TEMPLATE Page is Displayed");
		
		String templateName = GeneratorUtils.generateUniqueId("Template");
		createNewTemplatePage.setTemplateName(templateName);
		
		logStep("Select All Permissions");
		createNewTemplatePage.selectAllPermissionsOnPage("1");
		createNewTemplatePage.selectAllPermissionsOnPage("2");
		createNewTemplatePage.selectAllPermissionsOnPage("3");
		
		String successMessage = "Request completed successfully";
		
		createNewTemplatePage.clickSubmit();
		assertTrue(createNewTemplatePage.getMessages(successMessage), successMessage+" - Message is Displayed");
		
		logStep("Verify newly created template");
		permissionSectionPage.clickSearchTextAs(templateName);
		assertTrue(permissionSectionPage.isDetailDisplayed(templateName), templateName+" is Displayed Successfully");
		
		logStep("Edit newly created template");
		createNewTemplatePage = permissionSectionPage.clickEditTemplate();
		
		logStep("Deselect Some Permissions");
		createNewTemplatePage.selectAllPermissionsOnPage("1");
		createNewTemplatePage.selectAllPermissionsOnPage("2");
		
		successMessage = "Data Updated successfully";
		
		createNewTemplatePage.clickSubmit();
		assertTrue(createNewTemplatePage.getMessages(successMessage), successMessage+" - Message is Displayed");
		closeBrowser();
	}
}
