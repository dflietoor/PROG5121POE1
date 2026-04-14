import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit tests for the Login class.
 * Test data as specified in the PROG5121 assignment brief.
 */
public class LoginTest {

    private Login login;

    @Before
    public void setUp() {
        // Set up a valid registered user before each test
        login = new Login("John", "Doe", "kyl_1", "Ch&&sec@ke99!", "+27831234567");
    }

    // -----------------------------------------------------------------------
    // checkUserName
    // -----------------------------------------------------------------------

    @Test
    public void testUsernameCorrectlyFormatted() {
        // Test Data: "kyl_1" — has underscore, 5 chars
        Login validUser = new Login("John", "Doe", "kyl_1", "Ch&&sec@ke99!", "+27831234567");
        assertEquals("Username successfully captured.", getRegisterUsernameOnly(validUser));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        // Test Data: "kyle!!!!!!!" — no underscore, too long
        Login invalidUser = new Login("John", "Doe", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27831234567");
        assertEquals(
            "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.",
            getRegisterUsernameOnly(invalidUser)
        );
    }

    // -----------------------------------------------------------------------
    // checkPasswordComplexity
    // -----------------------------------------------------------------------

    @Test
    public void testPasswordMeetsComplexity() {
        // Test Data: "Ch&&sec@ke99!"
        Login validUser = new Login("John", "Doe", "kyl_1", "Ch&&sec@ke99!", "+27831234567");
        assertTrue("Password should meet complexity requirements",
                   validUser.checkPasswordComplexity());
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        // Test Data: "password" — no capital, no number, no special char
        Login invalidUser = new Login("John", "Doe", "kyl_1", "password", "+27831234567");
        assertFalse("Password should NOT meet complexity requirements",
                    invalidUser.checkPasswordComplexity());
    }

    // -----------------------------------------------------------------------
    // checkCellPhoneNumber
    // -----------------------------------------------------------------------

    @Test
    public void testCellPhoneCorrectlyFormatted() {
        // Valid SA number with +27 country code
        Login validUser = new Login("John", "Doe", "kyl_1", "Ch&&sec@ke99!", "+27831234567");
        assertTrue("Cell phone number should be valid", validUser.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneIncorrectlyFormatted() {
        // Test Data: "08966553" — no international code, too short
        Login invalidUser = new Login("John", "Doe", "kyl_1", "Ch&&sec@ke99!", "08966553");
        assertFalse("Cell phone number should be invalid", invalidUser.checkCellPhoneNumber());
    }

    // -----------------------------------------------------------------------
    //  testloginUser (True/False)
    // -----------------------------------------------------------------------

    @Test
    public void testLoginSuccessful() {
        // Correct credentials should return true
        assertTrue("Login should be successful", login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginFailed() {
        // Wrong credentials should return false
        assertFalse("Login should fail", login.loginUser("kyl_1", "wrongpassword"));
    }

    // -----------------------------------------------------------------------
    // Boolean check (True/False) for username,password and cellphone number
    // -----------------------------------------------------------------------

    @Test
    public void testCheckUserNameTrue() {
        assertTrue("Username 'kyl_1' should be correctly formatted",
                   login.checkUserName());
    }

    @Test
    public void testCheckUserNameFalse() {
        Login badUser = new Login("John", "Doe", "kyle!!!!!!!", "Ch&&sec@ke99!", "+27831234567");
        assertFalse("Username 'kyle!!!!!!!' should be incorrectly formatted",
                    badUser.checkUserName());
    }

    @Test
    public void testCheckPasswordComplexityTrue() {
        assertTrue("Password 'Ch&&sec@ke99!' should meet complexity",
                   login.checkPasswordComplexity());
    }

    @Test
    public void testCheckPasswordComplexityFalse() {
        Login badUser = new Login("John", "Doe", "kyl_1", "password", "+27831234567");
        assertFalse("Password 'password' should NOT meet complexity",
                    badUser.checkPasswordComplexity());
    }

    @Test
    public void testCheckCellPhoneNumberTrue() {
        assertTrue("Cell number '+27831234567' should be valid",
                   login.checkCellPhoneNumber());
    }

    @Test
    public void testCheckCellPhoneNumberFalse() {
        Login badUser = new Login("John", "Doe", "kyl_1", "Ch&&sec@ke99!", "08966553");
        assertFalse("Cell number '08966553' should be invalid",
                    badUser.checkCellPhoneNumber());
    }

    // -----------------------------------------------------------------------
    // check Return Login Status
    // -----------------------------------------------------------------------

    @Test
    public void testReturnLoginStatusSuccess() {
        String status = login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!");
        assertEquals("Welcome John Doe it is great to see you again.", status);
    }

    @Test
    public void testReturnLoginStatusFailed() {
        String status = login.returnLoginStatus("kyl_1", "wrongpass");
        assertEquals("Username or password incorrect, please try again.", status);
    }

    // -----------------------------------------------------------------------
    // Helper — isolates username-only registration message for testing
    // -----------------------------------------------------------------------
    private String getRegisterUsernameOnly(Login l) {
        if (!l.checkUserName()) {
            return "Username is not correctly formatted; please ensure that your username "
                 + "contains an underscore and is no more than five characters in length.";
        }
        return "Username successfully captured.";
    }
}

    

