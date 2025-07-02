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
	private CreateNewCompanyPage createNewCompanyPage;
	private CompaniesPage companiesPage;
	private CallsPage callsPage;
	private CampaignsPage campaignsPage;
	private DocumentsPage documentsPage;
	private FormsPage formsPage;
	private TasksPage tasksPage;
	private EmailPage emailPage;
	private ReportsPage reportsPage;
	private CasesPage casesPage;
	private CreateNewTaskPage createNewTaskPage;
	

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
		this.dealsPage = new DealsPage(driver);
		this.createNewCompanyPage = new CreateNewCompanyPage(driver);
		this.companiesPage = new CompaniesPage(driver);
		this.callsPage = new CallsPage(driver);
		this.campaignsPage = new CampaignsPage(driver);
		this.documentsPage = new DocumentsPage(driver);
		this.formsPage = new FormsPage(driver);
		this.tasksPage = new TasksPage(driver);
		this.emailPage = new EmailPage(driver);
		this.reportsPage = new ReportsPage(driver);
		this.casesPage = new CasesPage(driver);
		this.createNewTaskPage=new CreateNewTaskPage(driver);

	}

	public CasesPage getCasesPage() {
		return casesPage;
	}

	public CreateNewTaskPage getCreateNewTaskPage() {
		return createNewTaskPage;
	}

	public EmailPage getEmailPage() {
		return emailPage;
	}

	public ReportsPage getReportsPage() {
		return reportsPage;
	}

	public CompaniesPage getCompaniesPage() {
		return companiesPage;
	}

	public CallsPage getCallsPage() {
		return callsPage;
	}

	public CampaignsPage getCampaignsPage() {
		return campaignsPage;
	}

	public DocumentsPage getDocumentsPage() {
		return documentsPage;
	}

	public FormsPage getFormsPage() {
		return formsPage;
	}

	public TasksPage getTasksPage() {
		return tasksPage;
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

	public CreateNewCompanyPage getCreateNewCompanyPage() {
		return createNewCompanyPage;
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
