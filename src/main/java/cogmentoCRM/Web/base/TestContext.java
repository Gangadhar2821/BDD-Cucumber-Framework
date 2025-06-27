package cogmentoCRM.Web.base;

import org.openqa.selenium.WebDriver;

import cogmentoCRM.Web.pageObjects.*;
import cogmentoCRM.Web.utilities.ExcelUtil;
import cogmentoCRM.Web.utilities.LoggerUtil;

public class TestContext {

	private WebDriver driver;
	private LoggerUtil loggerUtil;
	private ExcelUtil excelUtil;

	private LoginPage loginPage;
	private HomePage homePage;
	private CreateNewContactPage createNewContactPage;
	private ContactsPage contactsPage;
	private CalenderPage calenderPage;
	private CreateNewEventPage createNewEventPage;
	private CreateNewDealPage createNewDealPage;
	private DealsPage dealsPage;

	public void initializeContext() {
		this.driver = WebDriverFactory.getDriver();
		this.loggerUtil = new LoggerUtil();
		this.excelUtil = new ExcelUtil();

		this.loginPage = new LoginPage(driver);
		this.homePage = new HomePage(driver);
		this.createNewContactPage = new CreateNewContactPage(driver);
		this.contactsPage = new ContactsPage(driver);
		this.calenderPage = new CalenderPage(driver);
		this.createNewEventPage = new CreateNewEventPage(driver);
		this.createNewDealPage = new CreateNewDealPage(driver);
		this.dealsPage=new DealsPage(driver);
	}

	public LoggerUtil getLoggerUtil() {
		return loggerUtil;
	}

	public DealsPage getDealsPage() {
		return dealsPage;
	}

	public CreateNewDealPage getCreateNewDealPage() {
		return createNewDealPage;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public LoggerUtil getLogger() {
		return loggerUtil;
	}

	public ExcelUtil getExcelUtil() {
		return excelUtil;
	}

	public LoginPage getLoginPage() {
		return loginPage;
	}

	public HomePage getHomePage() {
		return homePage;
	}

	public CreateNewContactPage getCreateNewContactPage() {
		return createNewContactPage;
	}

	public ContactsPage getContactsPage() {
		return contactsPage;
	}

	public CalenderPage getCalenderPage() {
		return calenderPage;
	}

	public CreateNewEventPage getCreateNewEventPage() {
		return createNewEventPage;
	}
}
