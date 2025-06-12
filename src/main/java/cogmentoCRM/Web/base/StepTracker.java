package cogmentoCRM.Web.base;

public class StepTracker {

	private static final ThreadLocal<String> currentMethod = new ThreadLocal<>();

	// Call this method before or during the step execution
	public static void setCurrentMethod(String methodName) {
		currentMethod.set(methodName);
	}

	// Retrieve the current method being executed
	public static String getCurrentMethod() {
		return currentMethod.get();
	}

	// Clear after step or scenario if needed
	public static void clear() {
		currentMethod.remove();
	}
}
