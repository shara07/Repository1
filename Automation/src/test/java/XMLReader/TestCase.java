package XMLReader;
import java.util.List;

public class TestCase {
	
	private String Name = null;
	private String Path = null;
	private String ApplcationName = null;
	private String ExecutionStatus  = null;
	List<TestStep> testSteps = null;
	
	public List<TestStep> getTestSteps() {
		return testSteps;
	}
	public void setTestSteps(List<TestStep> testSteps) {
		this.testSteps = testSteps;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPath() {
		return Path;
	}
	public void setPath(String path) {
		Path = path;
	}
	public String getApplcationName() {
		return ApplcationName;
	}
	public void setApplcationName(String applcationName) {
		ApplcationName = applcationName;
	}
	public String getExecutionStatus() {
		return ExecutionStatus;
	}
	public void setExecutionStatus(String executionStatus) {
		ExecutionStatus = executionStatus;
	}
}
