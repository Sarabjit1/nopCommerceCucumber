package stepDefinitions;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass 
{
	
	@Given("User Launch chrome browser")
	public void user_launch_chrome_browser() {
	
			
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		lp= new LoginPage(driver);
	   
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	    
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_Password_as(String email,String password) {
	    lp.setUserName(email);
	    lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() {
		lp.clickLogin();
	   
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessfull"))
		{
			driver.close();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertEquals(title, driver.getTitle());
		}
		   
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		lp.clickLogout();
		Thread.sleep(3000);
	   
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	     
	}
	
	//Customer feature step definitions
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	   addCust = new AddCustomerPage(driver);
	   Assert.assertEquals("Dashboard / nopCommerce administration",addCust.getPageTitle());
	}

	@When("User click on Customer Menu")
	public void user_click_on_customer_menu() throws InterruptedException {
		Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
	    
	}

	@When("click on customers Menu item")
	public void click_on_customers_menu_item() {
		addCust.clickOnCustomersMenuItem();
	    
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		addCust.clickOnAddNew();
	    
	}

	@Then("User can view Add new custimer page")
	public void user_can_view_add_new_custimer_page() 
	{
	    Assert.assertEquals("Add a new customer / nopCommerce administration",addCust.getPageTitle());
	    
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException 
	{
		String email = randomestring()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		addCust.setFirstName("Sarab");
		addCust.setLastName("Singh");
		addCust.setGender("Male");
		addCust.setDob("05/05/1991"); //dd/mm/yyyy
		addCust.setComapanyName("QATutuorial");
		
		//addCust.setCustomerRoles("Guest");
		addCust.setManagerVendor("Vendor 2");
		
		
		addCust.setComapanyName("QATutuorial");
		addCust.setAdminContent("This is for testing....");
		
	   
	}

	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException 
	{
	  addCust.clickOnSave();
	  Thread.sleep(2000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
	    		.contains("The new customer has been added successfully"));
	}
	
	
	//Steps for searching user by email id
	
	@When("Enter Customer Email")
	public void enter_customer_email() {
		searchCust = new SearchCustomerPage(driver);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
		
	}
	
	    

	@When("Click on Search Button")
	public void click_on_search_button() {
		searchCust.clickSearch();
	   
	}

	@Then("User should found Email in the search table")
	public void user_should_found_email_in_the_search_table() {
	    boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	    Assert.assertEquals(true, status);
	}




}
