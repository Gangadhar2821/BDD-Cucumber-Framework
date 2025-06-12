package cogmentoCRM.Web.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import cogmentoCRM.Web.utilities.LoggerUtil;
import io.qameta.allure.Attachment;

public class CogmentoCRM_Listener implements ITestListener {
	private LoggerUtil log;

	@Override
	public void onTestStart(ITestResult result) {
		log = new LoggerUtil();
		log.info("Test Listner Started Successfully");
	}

	@Override
	public void onTestSuccess(ITestResult result) {

	}

	@Override
	public void onTestFailure(ITestResult result) {
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onFinish(ITestContext context) {

	}

	@Attachment(value = "Failure Screenshot", type = "image/png")
	private byte[] saveScreenshotToAllure(byte[] screenshotBytes) {
		return screenshotBytes;
	}
}
