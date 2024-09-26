package RestApiTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;

public class POST {

    // Positive API Test : Valid login credentials
    public static void Post_ApiTest_Positive() {
        // Base URL
        RestAssured.baseURI = "https://reqres.in/api";

        // Request body
        JSONObject requestParams = new JSONObject();
        requestParams.put("email", "eve.holt@reqres.in");
        requestParams.put("password", "cityslicka");

        // Create Request
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());

        // Send POST Request
        Response response = request.post("/login");

        // Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Get Response Status Code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200, "Status code is not 200");

        System.out.println("API test was successfully Passed.");
    }

    // Negative API Test : Invalid email format
    public static void Post_ApiTest_Invalid_EmailFormat() {
        // Base URL
        RestAssured.baseURI = "https://reqres.in/api";

        // Request body
        JSONObject requestParams = new JSONObject();
        requestParams.put("email", "test");
        requestParams.put("password", "test");

        // Create Request
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());

        // Send POST Request
        Response response = request.post("/login");

        // Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Get Response Status Code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400, "Status code is not 400");
        Assert.assertTrue(responseBody.contains("user not found"));

        System.out.println("API test completed successfully.");
    }

    // Negative API Test : Invalid password
    public static void Post_ApiTest_InvalidPassword() {
        // Base URL
        RestAssured.baseURI = "https://reqres.in/api";

        // Request body
        JSONObject requestParams = new JSONObject();
        requestParams.put("email", "test@gmail.com");
        requestParams.put("password", "incorrectPassword");

        // Create Request
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());

        // Send POST Request
        Response response = request.post("/login");

        // Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Get Response Status Code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400, "Status code is not 400");
        Assert.assertTrue(responseBody.contains("user not found"));

        System.out.println("API test completed successfully.");
    }

    // Negative API Test : Missing email field
    public static void Post_ApiTest_MissingEmailField() {
        // Base URL
        RestAssured.baseURI = "https://reqres.in/api";

        // Request body
        JSONObject requestParams = new JSONObject();
        requestParams.put("password", "test");

        // Create Request
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());

        // Send POST Request
        Response response = request.post("/login");

        // Get Response Body
        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Get Response Status Code
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 400, "Status code is not 400");
        Assert.assertTrue(responseBody.contains("Missing email or username"));

        System.out.println("API test completed successfully.");
    }
}