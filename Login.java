/**
 * Login class for user registration and authentication.
 * 
 * Cell phone regex reference:
 * 
 * South African number format: +27 followed by exactly 9 digits (e.g. +27831234567)
 * 
 */
public class Login {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellPhoneNumber;

    // Constructor
    public Login(String firstName, String lastName, String username,
                 String password, String cellPhoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    /**
     * Checks that the username contains an underscore (_)
     * and is no more than five characters long.
     *
     * @return true if valid, false otherwise
     */
    public boolean checkUserName() {
        return username != null
                && username.contains("_")
                && username.length() <= 5;
    }

    /**
     * Checks that the password meets complexity requirements:
     * - At least 8 characters long
     * - Contains a capital letter
     * - Contains a number
     * - Contains a special character
     *
     * @return true if valid, false otherwise
     */
    public boolean checkPasswordComplexity() {
        if (password == null || password.length() < 8) return false;
        boolean hasUpper   = password.matches(".*[A-Z].*");
        boolean hasDigit   = password.matches(".*[0-9].*");
        boolean hasSpecial = password.matches(".*[^a-zA-Z0-9].*");
        return hasUpper && hasDigit && hasSpecial;
    }

    /**
     * Checks that the cell phone number contains the South African
     * international country code (+27) followed by exactly 9 digits,
     * making the total number no more than 12 characters (e.g. +27831234567).
     *
     *
     * @return true if valid, false otherwise
     */
    public boolean checkCellPhoneNumber() {
        // Pattern: starts with +27, followed by exactly 9 digits
        return cellPhoneNumber != null
                && cellPhoneNumber.matches("^\\+27[0-9]{9}$");
    }

    /**
     * Registers the user by validating all fields and returning
     * appropriate feedback messages.
     *
     * @return registration status message(s)
     */
    public String registerUser() {
        boolean validUsername = checkUserName();
        boolean validPassword = checkPasswordComplexity();
        boolean validCell     = checkCellPhoneNumber();
    }

        if (!validUsername) {
            return "Username is not correctly formatted; please ensure that your username "
                 + "contains an underscore and is no more than five characters in length.";
        }

        if (!validPassword) {
            return "Password is not correctly formatted; please ensure that the password "
                 + "contains at least eight characters, a capital letter, a number, and a "
                 + "special character.";
        }

        if (!validCell) {
            return "Cell number is incorrectly formatted or does not contain an international "
                 + "code; please correct the number and try again.";
        }

        return "Username successfully captured.\n"
             + "Password successfully captured.\n"
             + "Cell phone number successfully added.";
    }

    /**
     * Verifies that the entered login credentials match the stored credentials.
     *
     * @param enteredUsername the username entered at login
     * @param enteredPassword the password entered at login
     * @return true if credentials match, false otherwise
     */
    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    /**
     * Returns a login status message based on whether login was successful.
     *
     * @param enteredUsername the username entered at login
     * @param enteredPassword the password entered at login
     * @return welcome message or error message
     */
    public String returnLoginStatus(String enteredUsername, String enteredPassword) {
        if (loginUser(enteredUsername, enteredPassword)) {
            return "Welcome " + firstName + " " + lastName + " it is great to see you again.";
        }
        return "Username or password incorrect, please try again.";
    }
}
    

