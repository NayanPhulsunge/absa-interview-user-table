package interview;

import java.util.HashMap;
import java.util.List;

public final class TestInformation {

    private List<HashMap<String, String>> testDataMaps;
    private List<String> testKeywords;
    private String identifier;

    public TestInformation(List<HashMap<String, String>> testDataMaps, List<String> testKeywords, String identifier) {
        this.testDataMaps = testDataMaps;
        this.testKeywords = testKeywords;
        this.identifier = identifier;
    }

    public List<HashMap<String, String>> getTestDataMaps() {
        return testDataMaps;
    }

    public List<String> getTestKeywords() {
        return testKeywords;
    }

    public String getIdentifier() {
        return identifier;
    }
}
