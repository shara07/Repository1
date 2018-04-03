package XMLReader;
import java.util.List;

public class TestSuite {

	String TestSuiteName = null;
	String TestSuitePath = null;
	String Browser = null;
	String UrlAddress = null;
	String Maximise = null;
	
	List<TestCase> testCases = null;

	public List<TestCase> getTestCases() {
		return testCases;
	}

	public void setTestCases(List<TestCase> testCases) {
		this.testCases = testCases;
	}

	public String getTestSuiteName() {
		return TestSuiteName;
	}

	public void setTestSuiteName(String testSuiteName) {
		TestSuiteName = testSuiteName;
	}

	public String getTestSuitePath() {
		return TestSuitePath;
	}

	public void setTestSuitePath(String testSuitePath) {
		TestSuitePath = testSuitePath;
	}

	public String getBrowser() {
		return Browser;
	}

	public void setBrowser(String browser) {
		Browser = browser;
	}

	public String getUrlAddress() {
		return UrlAddress;
	}

	public void setUrlAddress(String urlAddress) {
		UrlAddress = urlAddress;
	}

	public String getMaximise() {
		return Maximise;
	}

	public void setMaximise(String maximise) {
		Maximise = maximise;
	}
}
