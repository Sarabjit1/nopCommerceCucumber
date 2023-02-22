package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AddCustomerPage {

	public WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(ldriver,this);
	}

	By lnkCustomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCustomers_menuitem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");

	By btnAddnew = By.xpath("//a[normalize-space()='Add new']"); //Add new

	By txtEmail = By.xpath("//input[@id='Email']");
	By txtPassword = By.xpath("//input[@id='Password']");

	By txtFirstname = By.xpath("//input[@id='FirstName']");
	By txtLastname = By.xpath("//input[@id='LastName']");
	By genderMale = By.xpath("//input[@id='Gender_Male']");
	By txtDob= By.xpath("//input[@id='DateOfBirth']");
	By genderFemale = By.xpath("//input[@id='Gender_Female']");
	By txtCompanyname = By.xpath("//input[@id='Company']");
	By chkTax = By.xpath("//input[@id='IsTaxExempt']");
	By txtNewsletter = By.xpath("//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover']");
	By selectCustomerroles = By.xpath("(//input[@role='listbox'])[2]");
	By multiVendors = By.xpath("//select[@id='VendorId']");
	By chkActive = By.xpath("//input[@id='Active']");
	By txtAdmincomment = By.xpath("//textarea[@id='AdminComment']");

	By btnSave = By.xpath("//button[@name='save']");

	By lstAdmin = By.xpath("//span[normalize-space()='Administrators']");
	By lstRegister = By.xpath("//span[normalize-space()='Registered']");
	By lstMod = By.xpath("//span[normalize-space()='Forum Moderators']");
	By lstGuest = By.xpath("//span[normalize-space()='Guests']");


	//Actions Methods
	
	public String getPageTitle()
	{
		return ldriver.getTitle();
	}

	public void clickOnCustomersMenu()
	{
		ldriver.findElement(lnkCustomers_menu).click();
	}

	public void clickOnCustomersMenuItem()
	{
		ldriver.findElement(lnkCustomers_menuitem).click();
	}

	public void clickOnAddNew()
	{
		ldriver.findElement(btnAddnew).click();
	}

	public void setEmail(String email)
	{
		ldriver.findElement(txtEmail).sendKeys(email);
	}

	public void setPassword(String password)
	{
		ldriver.findElement(txtPassword).sendKeys(password);
	}

	public void setCustomerRoles(String role) throws InterruptedException
	{
		ldriver.findElement(selectCustomerroles).click();

		WebElement listItem;
		Thread.sleep(3000);

		if(role.equals("Administrators"))
		{
			listItem = ldriver.findElement(lstAdmin);
		}
		else if(role.equals("Guests"))
		{
			listItem = ldriver.findElement(lstGuest);
		}
		else if(role.equals("Registered"))
		{
			listItem = ldriver.findElement(lstRegister);
		}
		else
		{
			listItem = ldriver.findElement(lstGuest);
		}

		listItem.click();
	}
	
	public void setManagerVendor(String value)
	{
		Select drp = new Select(ldriver.findElement(multiVendors));
	    drp.selectByVisibleText(value);
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(genderMale).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(genderFemale).click();
		}
		else
		{
			ldriver.findElement(genderMale).click(); //Default
		}
	}
	
	public void setFirstName(String fname)
	{
		ldriver.findElement(txtFirstname).sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		ldriver.findElement(txtLastname).sendKeys(lname);
	}
	
	public void setDob(String dob)
	{
		ldriver.findElement(txtDob).sendKeys(dob);
	}
	public void setComapanyName(String comname)
	{
		ldriver.findElement(txtCompanyname).sendKeys(comname);
	}
	
	public void setAdminContent(String content)
	{
		ldriver.findElement(txtAdmincomment).sendKeys(content);
	}
	
	public void clickOnSave()
	{
		ldriver.findElement(btnSave).click();
	}
	
	


}
