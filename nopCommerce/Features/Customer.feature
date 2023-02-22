Feature: Customers

 Background: Below are common steps for each scenario
   Given User Launch chrome browser
   When User opens URL "https://admin-demo.nopcommerce.com/login"
   And User enters Email as "admin@yourstore.com" and Password as "admin"
   And Click on Login
   Then User can view Dashboard
   When User click on Customer Menu
   And click on customers Menu item
@sainty
Scenario: Add new Customer
   
   And click on Add new button
   Then User can view Add new custimer page
   When User enter customer info
   And click on Save button
   Then User can view confirmation message "The new customer has been added successfully."
   And close browser
 @regression 
 Scenario: Search Customer by EmailID
    And Enter Customer Email
   When Click on Search Button
   Then User should found Email in the search table
   And close browser
 