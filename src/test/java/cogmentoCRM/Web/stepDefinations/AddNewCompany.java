package cogmentoCRM.Web.stepDefinations;

import java.util.Map;

import cogmentoCRM.Web.base.ScenarioContextManager;
import cogmentoCRM.Web.base.TestContext;
import cogmentoCRM.Web.pageObjects.CreateNewCompanyPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewCompany {
	private final TestContext context;

	public AddNewCompany() {
		this.context = ScenarioContextManager.getContext();
	}

	@Given("The User is on the Home Page")
	public void verifyHomePage() {
		context.getHomePage().verifyHomePageIsDisplayed();
	}

	@When("The User navigates to the Companies Page")
	public void navigateToCompanyPage() {
		context.getHomePage().clickIcon_Companies();
	}

	@When("User Clicks on the Create button")
	public void clickOnCreateButton() {
		context.getCompaniesPage().click_CreateBtn();
	}

	@When("fills all the required company details")
	public void enterNewCompanyDetails() {
		Map<String, String> data = context.getExcelUtil().getTestDataForMethod("enterNewCompanyDetails");
		context.getCreateNewCompanyPage().verifyCreateNewComapanyPage();
		context.getCreateNewCompanyPage().createNewCompany(data);
	}

	@When("saves the form")
	public void clickSaveButton() {
		context.getCreateNewCompanyPage().click_BtnSave();
	}

	@Then("The comapany should  appear in the company list")
	public void verifyCreatedCompanyIsListed() {
		context.getHomePage().clickIcon_Companies();
		context.getCompaniesPage().verifyCreatedCompanyisListed(CreateNewCompanyPage.referenceValue);
	}

}
