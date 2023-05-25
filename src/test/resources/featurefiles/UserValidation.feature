Feature: Validating the user validations using APIs

Background: 
   Given the user sets the Base URL
   @register
  Scenario Outline: Verify the registration of the user
   Given The user provides payload "<name>" "<emailaddress>" "<password>"
   When user calls the API using "post" and  "/users/register"
   Then verify "<StatusCode>" "<message>" in registerpage response body 
   
  Examples:
   |name|emailaddress|password|StatusCode|message|
   |meenakumari|sunset@mailsac.com|Hello123$|201|User account created successfully|
   
   @login
  Scenario Outline: Verify the login function
   Given the user provides the Payload "<username>" "<password>" 
   When user calls the API using "post" and  "/users/login"
   Then  verify "<StatusCode>" "<message>" in loginpage response body 
     
  Examples:
   |username|password|StatusCode|message|
   |sunset@mailsac.com|Hello123$|200|Login successful|
     
  
        
  