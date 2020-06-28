package interview;

import interview.usertable.UserTable;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public abstract class Test {

    public abstract TestInformationReader getReader();
    public abstract TestStepExecutor getExecutor(WebDriver d);

    /**
     * Any new test need to be added here.
     * @return
     */
    public static List<Test> getTestObjects(){
        List<Test> testObjects = new ArrayList<>();
        testObjects.add(new UserTable());
        return testObjects;
    }
}
