Feature: Customers Role Update

Scenario: Below are common steps for each scenario
   Given User Launch chrome browser
   When User opens URL "https://admin-demo.nopcommerce.com/login"
   And User enters Email as "admin@yourstore.com" and Password as "admin"
   And Click on Login
   Then User can view Dashboard
   When User click on Customer Menu
   Then User click on Customer Role