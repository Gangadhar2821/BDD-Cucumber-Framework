package cogmentoCRM.Web.hooks;

import cogmentoCRM.Web.base.BasePage;
import cogmentoCRM.Web.base.ScenarioContextManager;
import cogmentoCRM.Web.base.StepTracker;
import cogmentoCRM.Web.base.TestContext;
import cogmentoCRM.Web.base.WebDriverFactory;
import cogmentoCRM.Web.utilities.ConfigUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

	@Before(order = 0)
	public void startDriver() {
		WebDriverFactory.initializeDriver(); // Thread-local driver created
		TestContext context = new TestContext(); // New isolated context
		context.initializeContext(); // Initialize all pages and utils
		ScenarioContextManager.setContext(context); // Bind to current thread
		context.getLogger().info("Driver initialized and context created.");
	}

	@Before(order = 1)
	public void login() {
		TestContext context = ScenarioContextManager.getContext();

		if (context.getLoginPage() == null) {
			context.getLoggerUtil().info("LoginPage not initialized. Skipping login.");
			return;
		}

		String username = ConfigUtil.get("username");
		String password = ConfigUtil.get("password");

		context.getLoginPage().enterEmail(username);
		context.getLoginPage().enterPassword(password);
		context.getLoginPage().clickLogin();

		context.getLoggerUtil().info("Logged into the Application...");
	}

	@After(order = 1)
	public void logout() {
		TestContext context = ScenarioContextManager.getContext();

		try {
			if (context.getHomePage() != null) {
				context.getHomePage().getIcon_Settings().click();
				context.getHomePage().getBtn_Logout().click();
				context.getLoggerUtil().info("Logged out of the Application...");
			}
		} catch (Exception e) {
			if (context.getLoggerUtil() != null) {
				context.getLoggerUtil().error("Logout failed: " + e.getMessage());
			} else {
				context.getLoggerUtil().error("Logout failed: " + e.getMessage());
			}
		} finally {
			WebDriverFactory.quitDriver(); // Quit the thread-local WebDriver
			ScenarioContextManager.removeContext(); // Clean up thread-local context
		}
	}

	@AfterStep
	public void stepExecutionStatus(Scenario scenario) {

		if (scenario.isFailed()) {
			BasePage bp = new BasePage(WebDriverFactory.getDriver());
			bp.screenShotOnStepFailure(scenario);
			StepTracker.clear();
		}

	}

}
