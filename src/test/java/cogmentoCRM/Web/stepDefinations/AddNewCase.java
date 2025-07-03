package cogmentoCRM.Web.stepDefinations;

import java.util.Map;

import cogmentoCRM.Web.base.BaseTest;
import cogmentoCRM.Web.pageObjects.CreateNewCasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewCase extends BaseTest {

	@Given("The user is on the HomePage")
	public void verifyUserIsOnHomePage() {
		context.getHomePage().verifyHomePageIsDisplayed();
	}

	@When("the user navigates to the cases Page")
	public void navigateToCasesPage() {
		context.getHomePage().clickIcon_Cases();
	}

	@When("user clicks on the Create button")
	public void clickBtn_Create() {
		context.getCasesPage().clickBtn_Create();
	}

	@When("fills in all the required Case details")
	public void enterNewCaseDetails() {
		Map<String, String> data = context.getExcelUtil().getTestDataForMethod("enterNewCaseDetails");
		context.getCreateNewCasePage().createNewCase(data);
	}

	@When("save the details")
	public void clickSave_Btn() {
		context.getCreateNewCasePage().clickBtn_Save();
	}

	@Then("the Case should  appear in the Cases list")
	public void verifyCreatedCaseIsListed() {
		context.getHomePage().clickIcon_Cases();
		context.getCasesPage().validateCreatedContact(CreateNewCasePage.referenceValue);
	}

}
