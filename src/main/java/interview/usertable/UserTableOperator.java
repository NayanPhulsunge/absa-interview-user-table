package interview.usertable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserTableOperator {
	
	private static UserTableOperator operatorInstance;
	
	public static UserTableOperator getInstance(){
		if(operatorInstance == null) {
			operatorInstance = new UserTableOperator();
		}
		
		return operatorInstance;
	}

	public void openUrl(WebDriver d)
	{
		d.get("http://www.way2automation.com/angularjs-protractor/webtables/");
		d.manage().window().maximize();

	}
    
	public void clickOnAddUser(WebDriver d)
	{
		d.findElement(By.xpath("//button[@type = 'add']")).click();
	}
	
	public void enterFirstName(WebDriver d, String fn)
	{
		WebElement e = d.findElement(By.xpath("//input [@ name = 'FirstName']"));
		e.clear();
		e.sendKeys(fn);
	}
	
	public void enterLastName(WebDriver d, String ln)
	{
		WebElement e = d.findElement(By.xpath("//input[@ name = 'LastName']"));
		e.clear();
		e.sendKeys(ln);
	}
	
	public void enterUserName(WebDriver d, String un)
	{
		WebElement e = d.findElement(By.xpath("//input[@ name = 'UserName']"));
		e.clear();
		e.sendKeys(un);
	}
	
	public void enterPassword(WebDriver d, String pwd)
	
	{
		WebElement e = d.findElement(By.xpath("//input[@ name = 'Password']"));
		e.clear();
		e.sendKeys(pwd);
	}
	
	public void selectCustomerRadioButton(WebDriver d, String cust)
	{
		if(cust.equalsIgnoreCase("Company AAA"))
		{
			d.findElement(By.xpath("//input[@  value = '15']")).click();
			
		}
	
	
		if(cust.equalsIgnoreCase("Company BBB"))
		{
			d.findElement(By.xpath("//input[@  value = '16']")).click();
		}
	}	
	
	public void selectRole(WebDriver d, String role)
	{
		Select s = new Select(d.findElement(By.xpath("//select [@ name = 'RoleId']")));
		if(role.equalsIgnoreCase("Admin"))
        {
        	s.selectByVisibleText("Admin");
        }
		
		if(role.equalsIgnoreCase("Customer"))
        {
        	s.selectByVisibleText("Customer");
        }
		
		if(role.equalsIgnoreCase("Sales Team"))
        {
        	s.selectByVisibleText("Sales Team");
        }
	}
	
	
	public void enterEmail(WebDriver d, String email)
	{
		WebElement e = d.findElement(By.xpath("//input [@ name = 'Email']"));
		e.clear();
		e.sendKeys(email);
	}
	
	public void enterMobilePhone(WebDriver d, String mob)
	{
		WebElement e = d.findElement(By.xpath("//input [@ name = 'Mobilephone']"));
		 e.clear();
		 e.sendKeys(mob);
	}
	
	public void clickOnSaveButton(WebDriver d) throws Exception
	{
		Thread.sleep(3000);
		d.findElement(By.xpath("//button[@ ng-click = 'save(user)']")).click();
		System.out.print("Save clicked");
		Thread.sleep(3000);
	}
	
	public void validateUserPresent(WebDriver d, String fn) throws Exception
	{
		WebElement yourTable = d.findElement(By.tagName("table"));
		List<WebElement> tableRows = yourTable.findElements(By.tagName("tr"));
		for(int i=0; i<tableRows.size(); i++){
		    WebElement row  = tableRows.get(i);
		    List<WebElement> td = row.findElements(By.tagName("td"));
	        for (WebElement webElement : td) {
				if(fn.equalsIgnoreCase(webElement.getText())){
					return;
				}
			}
		}
		
		throw new Exception("User not added successfully");
	}
}
