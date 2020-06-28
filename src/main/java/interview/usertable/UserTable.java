package interview.usertable;

import interview.Test;
import interview.TestInformationReader;
import interview.TestStepExecutor;
import org.openqa.selenium.WebDriver;

public class UserTable extends Test {

    public static final String FIRST_NAME = "FirstName";
    public static final String LAST_NAME = "LastName";
    public static final String USER_NAME = "UserName";
    public static final String PASSWORD = "Password";
    public static final String CUSTOMER = "Customer";
    public static final String ROLE = "Role";
    public static final String EMAIL = "Email";
    public static final String CELL = "Cell";

    @Override
    public TestInformationReader getReader() {
        return new UserTableTestInformationReader();
    }

    @Override
    public TestStepExecutor getExecutor(WebDriver d) {
        return new UserTableTestStepExecutor(d);
    }
}
