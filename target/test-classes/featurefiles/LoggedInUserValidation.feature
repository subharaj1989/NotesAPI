Feature: Validate functions after User Logged IN

Background:
   Given the user sets the Base URL
   And the user provides the Payload "sunset@mailsac.com" "Hello123$" 
   And user calls the API using "post" and  "/users/login"
   And verify "200" "Login successful" in loginpage response body
 
   @updateProfie	
  Scenario Outline: Verify the profile update
   Given the user is loggedin
   When the user updates "<name>" "<phone>" "<company>"
   And user calls the API using "patch" and  "/users/profile"
   Then verify "<status code>" "<message>" in updateprofile response body
         
  Examples:
   |name|phone|company|status code|message|
   |MbcdeghtSit|1234567890|chef|200|Profile updated successful|
   
   @retreiveuserinfo
  Scenario Outline: Verify retrieval of user information
   Given the user is loggedin
   When user calls the API using "get" and  "/users/profile"
   Then verify "<StatusCode>" "<message>" in response body
   
  Examples:
  |StatusCode|message|
  |200|Profile successful|
  
   @ChangePassword
  Scenario Outline:
   Given the user is loggedin
   When the user sends "<current Password>" and "<New Password>"
   And user calls the API using "post" and  "/users/change-password"
   Then verify "<StatusCode>" "<message>" in change password response body
   
   Examples:
   |StatusCode|message|
   |200|The password was successfully updated|
  
   @Logout
  Scenario Outline:
   Given the user is loggedin
   When user calls the API using "delete" and  "/users/logout"
   Then verify "<StatusCode>" "<message>" in the response body
   Examples:
   |StatusCode|message|
   |200|User has been successfully logged out|
   
   @DeleteAccount
  Scenario Outline:
   Given the user is loggedin
   When user calls the API using "delete" and  "/users/delete-account"
   Then verify "<StatusCode>" "<message>" in the response body
   Examples:
   |StatusCode|message|
   |200|Account successfully deleted|
   
   
   
  
  