Feature: Validating the user validations using APIs

Background: 
   Given the user sets the Base URL
   @register
 Scenario Outline: Verify the registration of the user
   Given The user provides payload "<name>" "<emailaddress>" "<password>"
   When user calls the Post method to register the user to the application
   Then API status code should be "<StatusCode>"
   And verify "<message>" in its registerpage response body 
   
   Examples:
   |name|emailaddress|password|StatusCode|message|
   |monicageller|monica@gmail.com|Hello123$|201|User account created successfully|
   
   @login
   Scenario Outline: Verify the login function
     Given the user provides the Payload "<username>" "<password>" 
     When the user calls the post method with expected "<Status Code>"
     Then  verify "<message>" in its loginpage response body 
     
     Examples:
     |username|password|Status Code|message|
     |monica@gmail.com|Hello123$|200|Login successful|
     
     @retreiveuserinfo
     Scenario: Verify retrieval of user information
       Given the user loggedin 
       When the user calls Get method
       Then verify user info is correct
       
       @updateProfie
       Scenario Outline: Verify the profile update
         Given the user loggedin
         When the user updates "<name>" "<phone>" "<company>"
         And the user calls the post method 
         Then verify "<status code>" "<message>" its updateprofile response body
         
         Examples:
         |name|phone|company|status code|message|
         |MonicaGeller|1234567890|chef|200|Profile updated successful|