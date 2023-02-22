package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {

	public WebDriver ldriver;
	WaitHelper waithelper;
	
	public SearchCustomerPage(WebDriver driver)
	{
		ldriver = driver;
		PageFactory.initElements(ldriver,this);
	    waithelper = new WaitHelper(ldriver);	
	}
	
	@FindBy(xpath = "//input[@id='SearchEmail']")
	WebElement txtEmail;
	
	@FindBy(id = "SearchFirstName")
	WebElement txtFirstName;
	
	@FindBy(id = "SearchLastName")
	WebElement txtLastName;
	
	@FindBy(id = "search-customers")
	WebElement btnSearch;
	
	@FindBy(xpath = "//div[@id='customers-grid_wrapper']//tbody/tr/td")
	List<WebElement> tableCols;
	
	@FindBy(xpath = "//div[@id='customers-grid_wrapper']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath = "//div[@id='customers-grid_wrapper']")
	WebElement table;
	
	public void setEmail(String email)
	{
		waithelper.WaitForElement(txtEmail, Duration.ofSeconds(2000));
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	public void setFirstName(String fname)
	{
		txtFirstName.clear();
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.clear();
		txtLastName.sendKeys(lname);
	}
	
	public void clickSearch()
	{
		btnSearch.click();
	}
	
	public int getNoOfRows()
	{
		return (tableRows.size());
	}
	
	public int getNoOfCols()
	{
		return (tableCols.size());
	}
	
	public boolean searchCustomerByEmail(String email)
	{
		boolean flag = false;
		for(int i=1;i<=getNoOfRows();i++)
		{
			String emailId = table.findElement(By.xpath("//div[@id='customers-grid_wrapper']//tbody/tr["+i+"]/td[2]")).getText();
			if(emailId.equals(email))
			{
				flag = true;
			}
		}
		return flag;
	}
}
