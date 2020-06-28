package interview;

import java.io.IOException;

public interface TestInformationReader {
    TestInformation readData() throws IOException;
    String getTestName();
}
