package cogmentoCRM.Web.stepDefinations;

import java.util.Map;

import org.testng.Assert;

import cogmentoCRM.Web.base.ScenarioContextManager;
import cogmentoCRM.Web.base.TestContext;
import cogmentoCRM.Web.pageObjects.CreateNewEventPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddNewEvent {

	private final TestContext context;

	public AddNewEvent() {
		this.context = ScenarioContextManager.getContext();
	}

	@Given("The User is on HomePage")
	public void verifyUserIsOnHomePage() {
		Assert.assertTrue(context.getHomePage().getLogo_Username().isDisplayed(), "The User is not in the HomePage");
	}

	@Given("The user navigates to the Calender Page")
	public void navigateToCalenderPage() {
		context.getHomePage().clickIcon_Calender();
	}

	@Given("The user click on Create button")
	public void clickOnCreateButton() {
		context.getCalenderPage().clickonCreateBtn();
	}

	@Given("The user fills in all the required fields")
	public void enterNewEventDetails() {
		Map<String, String> data = context.getExcelUtil().getTestDataForMethod("enterNewEventDetails");
		context.getCreateNewEventPage().addNewEvent(data);
	}

	@Given("The user saves the Event")
	public void clickSaveButton() {
		context.getCreateNewEventPage().clickSaveBtn();
	}

	@Then("The Event should be add to the Event list")
	public void verifyCreatedEventIsListed() {
		context.getHomePage().clickIcon_Calender();
		context.getCalenderPage().validateAddedEvent(CreateNewEventPage.referenceValue);
	}

}
