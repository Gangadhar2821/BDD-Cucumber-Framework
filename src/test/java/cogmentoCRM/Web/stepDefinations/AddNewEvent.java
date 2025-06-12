package cogmentoCRM.Web.stepDefinations;

import java.util.Map;

import org.testng.Assert;

import cogmentoCRM.Web.base.BaseTest;
import cogmentoCRM.Web.pageObjects.CreateNewEventPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewEvent extends BaseTest {
	@Given("the user is on the Home Page")
	public void validateHomePage() {
		Assert.assertTrue(homePage.getLogo_Username().isDisplayed(), "The User is not in the HomePage");
	}

	@When("the user clicks the Calendar icon from the main menu")
	public void click_CalenderIcon() {
		homePage.clickIcon_Calender();
	}

	@When("the user clicks the Create Event button")
	public void click_EventCreateBtn() {
		calenderPage.clickonCreateBtn();
	}

	@When("the user enters data in all mandatory fields")
	public void fillEventDetails() {
		Map<String, String> data = excelUtil.getTestDataForMethod("fillEventDetails");
		createNewEventPage.addNewEvent(data);
	}

	@When("the user clicks the Save button")
	public void click_Savebtn() {
		createNewEventPage.clickSaveBtn();
	}

	@Then("the user should be navigated to the Event details page")
	public void validateEventDetailsPage() {
		Assert.assertEquals(createNewEventPage.getLogo_calenderIcon().isDisplayed(), true);
	}

	@Then("the user should see the event displayed in the Calendar")
	public void validateCreatedEvent() {
		homePage.clickIcon_Calender();
		calenderPage.validateAddedEvent(CreateNewEventPage.referenceValue);
	}

}
