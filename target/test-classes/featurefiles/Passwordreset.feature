Feature: Validate Password reset 

Background:
   Given the user sets the Base URL
   And the user enters "abc@mailsac.com" to send the link
   And user calls the API using "post" and  "/users/forgot-password"
   And verify "200" "Password reset link successfully sent to abc@mailsac.com. Please verify by clicking on the given link" in its ResetPasswordToMail reponse body
 
   @ResetToken
  Scenario Outline:
   Given the user checks the email for the token
   And user calls the API using "post" and  "/users/verify-reset-password-token"
   And verify if token is valid "<token_code>" "<token_message>" 
  Examples:
  |token_code|token_message|
  |200|The provided password reset token is valid|
   
   @resetPassword
  Scenario Outline:
   Given the user checks the email for the token
   When the user sends token and "<newPassword>"
   And user calls the API using "post" and  "/users/reset-password"
   Then verify if the password changed successfully "<code>" and "<message>"
   
  Examples:
  |newPassword|code|message|
  |Hello1234|200|The password was successfully updated|
   
   
  
  