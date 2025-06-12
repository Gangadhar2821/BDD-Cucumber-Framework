package cogmentoCRM.Web.stepDefinations;

import java.util.Map;

import org.testng.Assert;

import cogmentoCRM.Web.base.BaseTest;
import cogmentoCRM.Web.base.StepTracker;
import cogmentoCRM.Web.pageObjects.CreateNewContactPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Contact Module")
@Feature("Create Contact")
public class AddNewContact extends BaseTest {

	private static Map<String, String> data;

	@Story("As A user I can validate the Successful Login by presence of User Logo")
	@Severity(SeverityLevel.BLOCKER)
	@Description("This Test validates that the user is successfully Logged into to the Application")
	@Given("User is on the Home Page")
	public void validateHomePage() {
		Assert.assertTrue(homePage.getLogo_Username().isDisplayed(), "User is not on HomePage");
	}

	@Story("The web Page is navigated to Create contact page ")
	@Severity(SeverityLevel.NORMAL)
	@Description("This Tests navigates to the CreateContact page")
	@When("User clicks on the Add Contacts icon from the main menu")
	public void navigateToCreateContactPage() {
		homePage.clickIcon_Contacts();
		contactsPage.clickBtnCreateContact();
	}

	@Story("Validates CreateContact page")
	@When("User should be navigated to the Create New Contact page")
	public void validateCreateContactPage() {
		Assert.assertTrue(createNewContactpage.getLogo_screenTitle().isDisplayed(),
				"User failed to navigate to the CreateContact Page");
	}

	@Story("Filling all the mandatory fields")
	@When("User enters data in all mandatory fields")
	public void fillContactDetails() {
		StepTracker.setCurrentMethod("fillContactDetails");
		data = excelUtil.getTestDataForMethod("fillContactDetails");
		createNewContactpage.fillContactDetails(data);

	}

	@Story("Saving the Contact")
	@When("User Clicks on Save button")
	public void clickSaveBtn() {
		createNewContactpage.saveContact();
	}

	@Story("Validates the Created Contact")
	@Then("Contact should be added to the list in the Contacts page")
	public void validateCreatedContact() {
		StepTracker.setCurrentMethod("validateCreatedContact");
		homePage.clickIcon_Contacts();
		contactsPage.validateCreatedContact(CreateNewContactPage.referenceValue);

	}
}
