# PROG5121POE1
PART 1 of this assignment consists of a registration system that allows users to:
* Register an account
* Approve their username,password and phone number
* Log in using their registeted information
the registration system ensures that all the details that are added meet all the validation rules before allowing full access to the user.
----------------------------------------------------------------------------------------------------------------------------

 The registration rquirements are as follows:

 The username:
 * The username must contain an underscore (_)
 * There must not be more than 5 characters
If the username requirements are met a success message displays("username succesfully captured")
If the username requirements are not met a failure message displays("username is not correctly formatted, please ensure that your username contains an underscore and is not longer than 5 characters")

The password:
* Be atleast 8 characters long
* Contain atleast one capitl letter
* Contail atleast one number
* Contail atleast one special character
If the password requirements are met a success message displays("password successfully captured")
If the password requirements are not met a failure message displays("password is not correctly formatted. Please ensure that your password contains atleast 8 characters, a capital letter,a number and a special character")

The cell phone number:
* Must include a country code (e.g (+27) for South Africa)
* must not exceed 9 digits after the county codes
If the cell phone number requirements are met a success message displays("cell phone number successfully captured")
If the cell phone number requirements are not met a failure message displays("call phone number not correctly formatted or does not contain a country code")
----------------------------------------------------------------------------------------------------------------------------

logging in
