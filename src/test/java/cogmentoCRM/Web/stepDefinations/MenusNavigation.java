package cogmentoCRM.Web.stepDefinations;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import cogmentoCRM.Web.base.ScenarioContextManager;
import cogmentoCRM.Web.base.TestContext;
import cogmentoCRM.Web.base.WebDriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenusNavigation {
	private final TestContext context;

	public MenusNavigation() {
		this.context = ScenarioContextManager.getContext();
	}

	@Given("user click on Home Icon")
	public void clickIcon_Home() {
		context.getHomePage().clickIcon_Home();
	}

	@Given("verifies the HomePage")
	public void verifyHomePage() {
		Assert.assertEquals(WebDriverFactory.getDriver().getCurrentUrl(), "https://ui.cogmento.com/home");
	}

	@When("the user click on the Calender icon")
	public void clickIcon_Calender() {
		context.getHomePage().clickIcon_Calender();
	}

	@When("verifies the CalenderPage")
	public void verifyCalenderPage() {
		assertTrue(context.getCalenderPage().getScreenTitle().getText().equalsIgnoreCase("Calendar"));
	}

	@When("the user click on Contact icon")
	public void clickIcon_Contact() {
		context.getHomePage().clickIcon_Contacts();
	}

	@When("verifies the Contact page")
	public void verifyContactsPage() {
		assertTrue(context.getContactsPage().getScreenTitle().getText().equalsIgnoreCase("contacts"));
	}

	@When("user click on Companies icon")
	public void clickIcon_Companies() {
		context.getHomePage().clickIcon_Companies();
	}

	@When("user verifies the Companies Page")
	public void verifyCompanyPage() {
		assertTrue(context.getCompaniesPage().getScreenTitle().getText().equalsIgnoreCase("companies"));
	}

	@When("user click on Deals icon")
	public void clickIcon_Deals() {
		context.getHomePage().clickIcon_Deals();
	}

	@When("user verifies the Deals Page")
	public void verifyDealsPage() {
		assertTrue(context.getDealsPage().getScreenTitle().getText().equalsIgnoreCase("deals"));
	}

	@When("user click on Tasks icon")
	public void clickIcon_Tasks() {
		context.getHomePage().clickIcon_Tasks();
	}

	@When("user verifies the Tasks Page")
	public void verifyTasksPage() {
		assertTrue(context.getTasksPage().getScreenTitle().getText().equalsIgnoreCase("tasks"));
	}

	@When("user click on Cases icon")
	public void clickIcon_Cases() {
		context.getHomePage().clickIcon_Cases();
	}

	@When("user verifies the Cases Page")
	public void verifyCasesPage() {
		assertTrue(context.getCasesPage().getScreenTitle().getText().equalsIgnoreCase("cases"));

	}

	@When("user click on Calls icon")
	public void clickIcon_Calls() {
		context.getHomePage().clickIcon_Calls();
	}

	@When("user verifies the Calls Page")
	public void verifyCallsPage() {
		assertTrue(context.getCallsPage().getScreenTitle().getText().equalsIgnoreCase("calls"));
	}

	@When("user click on Documents icon")
	public void clickIcon_Documents() {
		context.getHomePage().clickIcon_Documents();
	}

	@When("user verifies the Documents Page")
	public void verifyDocumentsPage() {
		assertTrue(context.getDocumentsPage().getScreenTitle().getText().equalsIgnoreCase("documents"));
	}

	@When("user click on Email icon")
	public void clickIcon_Email() {
		context.getHomePage().clickIcon_Email();
	}

	@When("user verifies the Inbox Page")
	public void verifyInboxPage() {
		assertTrue(context.getEmailPage().getScreenTitle().getText().equalsIgnoreCase("Inbox"));
	}

	@When("user click on Campaigns icon")
	public void clickIcon_Campaigns() {
		context.getHomePage().clickIcon_Campaigns();
	}

	@When("user verifies the Campaigns Page")
	public void verifyCampaignsPage() {
		assertTrue(context.getCampaignsPage().getScreenTitle().getText().equalsIgnoreCase("campaigns"));
	}

	@When("user click on Forms icon")
	public void clickIcon_Forms() {
		context.getHomePage().clickIcon_Forms();
	}

	@When("user verifies the Forms Page")
	public void verifyFormsPage() {
		assertTrue(context.getFormsPage().getScreenTitle().getText().equalsIgnoreCase("forms"));
	}

	@When("user click on Reports icon")
	public void clickIcon_Reports() {
		context.getHomePage().clickIcon_Reports();
	}

	@When("user verifies the Reports Page")
	public void verifyReportsPage() {
		assertTrue(context.getReportsPage().getScreenTitle().getText().equalsIgnoreCase("Reports"));
	}

	@When("User click on Home Icon again")
	public void clickIcon_HomeAgain() {
		context.getHomePage().clickIcon_Home();
	}

	@Then("The user should be able to return to the HomePage")
	public void verifyReturnHome() {
		Assert.assertEquals(WebDriverFactory.getDriver().getCurrentUrl(), "https://ui.cogmento.com/home");
	}

}
