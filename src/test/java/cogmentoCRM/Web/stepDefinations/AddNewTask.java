package cogmentoCRM.Web.stepDefinations;

import java.util.Map;

import cogmentoCRM.Web.base.BaseTest;
import cogmentoCRM.Web.pageObjects.CreateNewTaskPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddNewTask extends BaseTest {

	@Given("The User is on the HomePage")
	public void verifyUserIsOnHomePage() {
		context.getHomePage().verifyHomePageIsDisplayed();
	}

	@When("The User navigates to the Tasks Page")
	public void navigateToTasksPage() {
		context.getHomePage().clickIcon_Tasks();
	}

	@When("User clicks on the Create button")
	public void clickBtn_Create() {
		context.getTasksPage().clickBtn_Create();
	}

	@When("fills all the required task details")
	public void enterNewTaskDetails() {
		Map<String, String> data = context.getExcelUtil().getTestDataForMethod("enterNewTaskDetails");
		context.getCreateNewTaskPage().createNewTask(data);
	}

	@When("save the form")
	public void saveTask() {
		context.getCreateNewTaskPage().clickBtn_Save();
	}

	@Then("The Task should  appear in the Tasks list")
	public void verifyCreatedTaskIsListed() {
		context.getHomePage().clickIcon_Tasks();
		context.getTasksPage().verifyIsTaskListed(CreateNewTaskPage.referenceValue);
	}

}
