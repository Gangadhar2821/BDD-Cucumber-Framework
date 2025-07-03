package cogmentoCRM.Web.stepDefinations;

import java.util.Map;

import org.testng.Assert;

import cogmentoCRM.Web.base.BaseTest;
import cogmentoCRM.Web.pageObjects.CreateNewContactPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewContact extends BaseTest {

	@Given("the user is on the Home page")
	public void verifyUserIsOnHomePage() {
		Assert.assertTrue(context.getHomePage().getLogo_Username().isDisplayed(), "User is not on HomePage");
	}

	@When("the user navigates to the Contacts page")
	public void navigateToContactPage() {
		context.getHomePage().clickIcon_Contacts();
	}

	@When("clicks on the Create button")
	public void clickCreateButton() {
		context.getContactsPage().clickBtnCreateContact();
	}

	@When("fills in all the required contact details")
	public void enterNewContactDetails() {
		Map<String, String> data = context.getExcelUtil().getTestDataForMethod("enterNewContactDetails");
		context.getCreateNewContactPage().fillContactDetails(data);
	}

	@When("submits the form")
	public void clickSaveButton() {
		context.getCreateNewContactPage().clickSaveBtn();
	}

	@Then("the new contact should appear in the contact list")
	public void verifyCreatedContactInList() {
		context.getHomePage().clickIcon_Contacts();
		context.getCreateNewContactPage();
		context.getContactsPage().validateCreatedContact(CreateNewContactPage.referenceValue);
	}

}
