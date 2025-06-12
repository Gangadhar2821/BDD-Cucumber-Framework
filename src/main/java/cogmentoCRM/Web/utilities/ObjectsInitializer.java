package cogmentoCRM.Web.utilities;

import org.testng.annotations.BeforeTest;

import cogmentoCRM.Web.base.BaseTest;
import cogmentoCRM.Web.pageObjects.CalenderPage;
import cogmentoCRM.Web.pageObjects.ContactsPage;
import cogmentoCRM.Web.pageObjects.CreateNewContactPage;
import cogmentoCRM.Web.pageObjects.CreateNewEventPage;
import cogmentoCRM.Web.pageObjects.HomePage;
import cogmentoCRM.Web.pageObjects.LoginPage;

public class ObjectsInitializer extends BaseTest {

	@BeforeTest
	public static void intialize() {
		log = new LoggerUtil();
		excelUtil = new ExcelUtil();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		createNewContactpage = new CreateNewContactPage(driver);
		contactsPage = new ContactsPage(driver);
		calenderPage = new CalenderPage(driver);
		createNewEventPage = new CreateNewEventPage(driver);

	}

}
