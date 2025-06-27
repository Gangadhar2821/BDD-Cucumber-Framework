package cogmentoCRM.Web.stepDefinations;

import java.util.Map;

import org.testng.Assert;

import cogmentoCRM.Web.base.ScenarioContextManager;
import cogmentoCRM.Web.base.TestContext;
import cogmentoCRM.Web.pageObjects.CreateNewDealPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AddNewDeal {

	private final TestContext context;

	public AddNewDeal() {
		this.context = ScenarioContextManager.getContext();
	}

	@Given("The user is on HomePage")
	public void VerifyUserIsOnHomePage() {
		Assert.assertTrue(context.getHomePage().getLogo_Username().isDisplayed());
	}

	@Given("The User navigates to Deals Page")
	public void navigateToDealPage() {
		context.getHomePage().clickIcon_Deals();
	}

	@Given("The User click on Create button")
	public void clickCreatBtn() {
		context.getDealsPage().click_CreateBtn();
	}

	@Given("The User fills in all the required Deal details")
	public void enterNewDealDetails() {
		Map<String, String> data = context.getExcelUtil().getTestDataForMethod("enterNewDealDetails");
		context.getCreateNewDealPage().createDeal(data);
	}

	@Given("The User saves the Deal")
	public void saveDeal() {
		context.getCreateNewDealPage().clickSaveBtn();
	}

	@Then("The Deals should appear in the Deals list")
	public void verifyCreatedDealinList() {
		context.getHomePage().clickIcon_Deals();
		context.getCreateNewDealPage();
		context.getDealsPage().validateCreatedDeal(CreateNewDealPage.referenceValue);
	}
}
