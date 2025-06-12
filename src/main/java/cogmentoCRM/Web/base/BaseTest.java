package cogmentoCRM.Web.base;

import org.openqa.selenium.WebDriver;

import cogmentoCRM.Web.pageObjects.CalenderPage;
import cogmentoCRM.Web.pageObjects.ContactsPage;
import cogmentoCRM.Web.pageObjects.CreateNewContactPage;
import cogmentoCRM.Web.pageObjects.CreateNewEventPage;
import cogmentoCRM.Web.pageObjects.HomePage;
import cogmentoCRM.Web.pageObjects.LoginPage;
import cogmentoCRM.Web.utilities.ExcelUtil;
import cogmentoCRM.Web.utilities.LoggerUtil;
import cogmentoCRM.Web.utilities.ObjectsInitializer;

/**
 * @author gangadhar.b
 */
public class BaseTest {

	// variables
	protected static WebDriver driver;
	protected static LoggerUtil log;
	protected static LoginPage loginPage;
	protected static HomePage homePage;
	protected static CreateNewContactPage createNewContactpage;
	protected static ContactsPage contactsPage;
	protected static ExcelUtil excelUtil;
	protected static CalenderPage calenderPage;
	protected static CreateNewEventPage createNewEventPage;

	public void setup() {
		driver = WebDriverFactory.getDriver();
		ObjectsInitializer.intialize();

	}

	public void tearDown() {
		WebDriverFactory.quitDriver();
	}

}
