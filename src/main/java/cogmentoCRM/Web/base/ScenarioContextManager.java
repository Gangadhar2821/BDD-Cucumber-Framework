package cogmentoCRM.Web.base;

public class ScenarioContextManager {

	private static final ThreadLocal<TestContext> threadLocalContext = new ThreadLocal<>();

	public static TestContext getContext() {
		return threadLocalContext.get();
	}

	public static void setContext(TestContext context) {
		threadLocalContext.set(context);
	}

	public static void removeContext() {
		threadLocalContext.remove();
	}
}
