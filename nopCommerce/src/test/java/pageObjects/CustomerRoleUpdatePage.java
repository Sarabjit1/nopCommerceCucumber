package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class CustomerRoleUpdatePage 
{
	WebDriver ldriver;
	WaitHelper waithelper;
	
	public CustomerRoleUpdatePage(WebDriver rdriver)
	{
		ldriver =rdriver;
		PageFactory.initElements(ldriver,this);
		waithelper = new WaitHelper(ldriver);
	}
	
	@FindBy(xpath = "//p[normalize-space()='Customer roles']")
	WebElement cust_roles;
	
	public void clickRoles()
	{
		cust_roles.click();
	}
	
	

}
