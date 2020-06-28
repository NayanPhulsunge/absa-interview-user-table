package interview;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;

public class TestRunner {


	public static void main(String[] args) throws Exception
	{
		WebDriverManager.chromedriver().setup();
		WebDriver d =new ChromeDriver();
		for (Test t:Test.getTestObjects()
			 ) {
			execute(t.getReader().readData(), t.getExecutor(d), t.getReader().getTestName());
		}
	}

	private static void execute(TestInformation testInfo, TestStepExecutor ex, String testName) {
		for (HashMap<String,String> testEntity: testInfo.getTestDataMaps()) {
			try{
				for (String testStep: testInfo.getTestKeywords()) {
					ex.executeStep(testStep, testEntity);
				}
			}catch(Exception e) {
				System.out.println(
						"Failed Test Execution: Test Name - " + testName
								+ " - Test Entity Identifier - "
								+ testEntity.get(testInfo.getIdentifier()));
				//TODO - Reporting Logic For Failure of One Test Execution
			}
			//TODO - Reporting Logic of Success for One success Test Execution
		}
		//TODO - Summary Reporting Logic
	}
}
