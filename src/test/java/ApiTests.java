import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.IOException;

import static RestApiTest.POST.*;

public class ApiTests {

    @Test(priority = 1)
    public void RestAssured_APITest() {

        // Positive Scenario : Valid Response with token as output
        Post_ApiTest_Positive();

        // Negative Scenario : Invalid email format
        Post_ApiTest_Invalid_EmailFormat();

        // Negative API Test : Invalid password
        Post_ApiTest_InvalidPassword();

        // Negative API Test : Missing email field
        Post_ApiTest_MissingEmailField();
    }
}