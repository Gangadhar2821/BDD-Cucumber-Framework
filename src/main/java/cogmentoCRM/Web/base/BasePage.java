package cogmentoCRM.Web.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import cogmentoCRM.Web.utilities.ElementActionsImpl;
import cogmentoCRM.Web.utilities.LoggerUtil;
import io.cucumber.java.Scenario;

public class BasePage {

	protected static WebDriver driver;
	protected ElementActionsImpl elementActions;
	protected static LoggerUtil log;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.elementActions = new ElementActionsImpl(driver);
		log = new LoggerUtil();
	}

	public static void screenShotOnStepFailure(Scenario scenario) {
		try {
			WebDriver driver = WebDriverFactory.getDriver();
			log.info("Capturing the failure Screenshot..");
			Thread.sleep(1000);

			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Create screenshot filename
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String sanitizedScenarioName = scenario.getName().replaceAll("[^a-zA-Z0-9_\\-]", "_");
			String methodName = StepTracker.getCurrentMethod();
			if (methodName == null || methodName.isEmpty()) {
				methodName = "unknownMethod";
			}

			// Create directory
			String screenshotDir = "errorshots/" + new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			File folder = new File(screenshotDir);
			if (!folder.exists())
				folder.mkdirs();

			File screenshotFile = new File(folder, sanitizedScenarioName + methodName + "_" + timestamp + ".png");
			FileUtils.copyFile(screenshot, screenshotFile);

			log.info("Failed scenario's Screenshot saved at : " + screenshotFile.getAbsolutePath());

			// Convert to byte[]
			byte[] screenshotBytes = FileUtils.readFileToByteArray(screenshotFile);

			scenario.attach(screenshotBytes, "image/png",
					sanitizedScenarioName + "_" + methodName + "_" + timestamp + ".png");

		} catch (Exception e) {
			log.error("Failed to capture screenshot: " + e.getMessage());
		}
	}

	public void dateandTimePicker(String data) {
		log.info("Performing calender Input");

		String[] splitdata = data.split(" ");
		String dataMonth = splitdata[1];
		String dataDate = splitdata[2];
		String dataYear = splitdata[splitdata.length - 1];
		String dataTime = splitdata[3];
		try {
			WebElement reqMonth = null;

			while (!data.isEmpty()) {
				reqMonth = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']"));
				String monthYearValue = reqMonth.getText().trim();
				if (monthYearValue.contains(dataMonth) && monthYearValue.contains(dataYear)) {
					List<WebElement> allDates = null;
					try {
						allDates = driver.findElements(By.xpath("//div[contains(@class,'day')]"));
						for (WebElement ele : allDates) {
							if (ele.isDisplayed()) {
								@Nullable
								String domAttribute = ele.getDomAttribute("aria-label");
								try {
									if (domAttribute.contains(dataDate) && domAttribute.contains(dataMonth)
											&& domAttribute.contains(dataYear)) {
										ele.click();
										break;
									}
								} catch (Exception e) {
								}
							}
						}
						break;
					} catch (Exception e) {
					}
				} else {
					WebElement nextMonthBtn = driver.findElement(By.xpath("//button[@aria-label='Next Month']"));
					nextMonthBtn.click();
					reqMonth = driver.findElement(By.xpath("//div[@class='react-datepicker__current-month']"));
				}
			}
			// picking Time
			List<WebElement> allTimes = driver.findElements(By.xpath("//ul[@aria-label='Time']//li"));
			for (WebElement ele : allTimes) {
				String time = ele.getText().trim();
				if (dataTime.contains(time)) {
					ele.click();
					break;
				}

			}
		} catch (Exception e) {
			log.error("Failed to perform Calender input as :" + data);
		}
	}

}
