package interview.usertable;
import interview.TestStepExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class UserTableTestStepExecutor implements TestStepExecutor {

    private WebDriver d;
    private boolean isUrlOpened;

    public UserTableTestStepExecutor(WebDriver d) {
        this.d = d;
        this.isUrlOpened = false;
    }

    @Override
    public void executeStep(String testStep, Map<String, String> testData) throws Exception{
        UserTableOperator operator = UserTableOperator.getInstance();

        if(!isUrlOpened && testStep.equalsIgnoreCase("OpenUrl"))
        {
            isUrlOpened = true;
            System.out.println("Opening URL for testing");
            operator.openUrl(d);

        }
        else if(testStep.equalsIgnoreCase("ClickOnAddUser"))
        {
            operator.clickOnAddUser(d);
        }

        else if(testStep.equalsIgnoreCase("EnterFirstName"))
        {
            operator.enterFirstName(d,testData.get(UserTable.FIRST_NAME));
        }

        else if(testStep.equalsIgnoreCase("EnterLastName"))
        {
            operator.enterLastName(d,testData.get(UserTable.LAST_NAME));
        }

        else if(testStep.equalsIgnoreCase("EnterUserName"))
        {
            operator.enterUserName(d,testData.get(UserTable.USER_NAME));
        }

        else if(testStep.equalsIgnoreCase("EnterPassword"))
        {
            operator.enterPassword(d,testData.get(UserTable.PASSWORD));
        }

        else if(testStep.equalsIgnoreCase("SelectCustomerRadioButton"))
        {
            operator.selectCustomerRadioButton(d,testData.get(UserTable.CUSTOMER));
        }

        else if(testStep.equalsIgnoreCase("SelectRole"))
        {
            operator.selectRole(d,testData.get(UserTable.ROLE));
        }

        else if(testStep.equalsIgnoreCase("EnterEmail"))
        {
            operator.enterEmail(d,testData.get(UserTable.EMAIL));
        }

        else if(testStep.equalsIgnoreCase("EnterMobilePhone"))
        {
            operator.enterMobilePhone(d,testData.get(UserTable.CELL));
        }

        else if(testStep.equalsIgnoreCase("ClickOnSaveButton"))
        {
            operator.clickOnSaveButton(d) ;
        }

        else if(testStep.equalsIgnoreCase("ValidateUserPresent")){
            operator.validateUserPresent(d, testData.get(UserTable.FIRST_NAME)) ;
        }
    }
}
