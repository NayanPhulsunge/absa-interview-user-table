package interview;

import java.util.Map;

public interface TestStepExecutor {
    void executeStep(String testStep, Map<String,String> testData) throws Exception;
}
