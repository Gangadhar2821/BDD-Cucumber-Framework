package cogmentoCRM.Web.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import cogmentoCRM.Web.utilities.ConfigUtil;
import cogmentoCRM.Web.utilities.LoggerUtil;

public class WebDriverFactory {

	private static WebDriver driver;
	private static LoggerUtil log;

	// Private constructor to prevent instantiation from other classes
	private WebDriverFactory() {
	}

	// Public method to provide access to the WebDriver instance
	public static WebDriver getDriver() {
		if (driver == null) {
			synchronized (WebDriverFactory.class) {
				if (driver == null) {
					initializeDriver();
				}
			}
		}
		return driver;
	}

	private enum BrowserType {
		CHROME, FIREFOX, EDGE
	}

	// Method to initialize the WebDriver based on browser config
	private static void initializeDriver() {
		log = new LoggerUtil();
		log.info("--- Started the WebDriver ---");
		ConfigUtil.loadConfig();
		boolean isHeadless = Boolean.parseBoolean(ConfigUtil.get("headless"));
		String browser = ConfigUtil.get("browser").toUpperCase();
		String url = ConfigUtil.get("baseUrl");

		switch (BrowserType.valueOf(browser)) {

		case CHROME:
			ChromeOptions chromeOptions = new ChromeOptions();
			if (isHeadless) {
				chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
				driver = new ChromeDriver(chromeOptions);
				log.info("Launched the Chrome Browser" + (isHeadless ? " in Headless Mode..." : "..."));
			} else {
				driver = new ChromeDriver();
				log.info("Launched the Chrome Browser...");
			}
			break;

		case FIREFOX:
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			if (isHeadless) {
				firefoxOptions.addArguments("-headless");
				driver = new FirefoxDriver(firefoxOptions);
				log.info("Launched the Firefox Browser" + (isHeadless ? " in Headless Mode..." : "..."));
			} else {
				driver = new FirefoxDriver();
				log.info("Launched the Firefox Browser...");
			}
			break;

		case EDGE:
			EdgeOptions edgeOptions = new EdgeOptions();
			if (isHeadless) {
				edgeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080");
				driver = new EdgeDriver(edgeOptions);
				log.info("Launched the Edge Browser" + (isHeadless ? " in Headless Mode..." : "..."));
			} else {
				driver = new EdgeDriver();
				log.info("Launched the Edge Browser...");
			}
			break;

		default:
			log.info("Invalid browser: " + browser);
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}

		driver.manage().window().maximize();
		log.info("Maximized the Browser...");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
		driver.get(url);
		log.info("Navigated to the Test URL...");
	}

	// Method to quit the WebDriver when the tests are done
	public static void quitDriver() {

		if (driver != null) {
			driver.quit();
			log.info("--Killed the WebDriver--");
			driver = null;
		}
	}
}
