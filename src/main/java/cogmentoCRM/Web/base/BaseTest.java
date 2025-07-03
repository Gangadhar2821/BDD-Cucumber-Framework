package cogmentoCRM.Web.base;

public abstract class BaseTest {

	protected final TestContext context;

	public BaseTest() {
		this.context = ScenarioContextManager.getContext();
	}
}
