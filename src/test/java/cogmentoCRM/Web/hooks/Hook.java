package cogmentoCRM.Web.hooks;

import cogmentoCRM.Web.base.BasePage;
import cogmentoCRM.Web.base.BaseTest;
import cogmentoCRM.Web.base.StepTracker;
import cogmentoCRM.Web.utilities.ConfigUtil;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;

public class Hook extends BaseTest {

	@Before(order = 1)
	public void Login() {
		setup();
		String username = ConfigUtil.get("username");
		String password = ConfigUtil.get("password");
		loginPage.enterEmail(username);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
		log.info("Logged into the Application...!");
	}

	@After(order = 1)
	public void logout() {
		homePage.getIcon_Settings().click();
		homePage.getBtn_Logout().click();
		log.info("Logged out of the Application...!");
		tearDown();

	}

	@AfterStep
	public void stepExecutionStatus(Scenario scenario) {

		if (scenario.isFailed()) {
			BasePage.screenShotOnStepFailure(scenario);
			StepTracker.clear();
		}

	}

}
