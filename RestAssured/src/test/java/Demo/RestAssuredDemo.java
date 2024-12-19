package Demo;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredDemo {

    public static void main(String[] args) {
        
        // Set Base URI
        RestAssured.baseURI = "https://reqres.in/api";

        // Perform a GET request to fetch users on page 2
        Response response = 
            given()
                .queryParam("page", 2) // Add query parameter
            .when()
                .get("/users") // Endpoint
            .then()
                .statusCode(200) // Assert status code
                .body("page", equalTo(2)) // Assert that page is 2
                .body("data.size()", greaterThan(0)) // Assert data array is not empty
                .body("data[0].email", notNullValue()) // Assert email of the first user is not null
                .log().all() // Log full response
                .extract().response();

        // Extract specific data from the response
        String firstUserEmail = response.jsonPath().getString("data[0].email");
        System.out.println("First user's email on page 2: " + firstUserEmail);

        // Automating additional checks
        // Assert if total pages are 2
        int totalPages = response.jsonPath().getInt("total_pages");
        assert totalPages == 2 : "Expected total pages to be 2 but found " + totalPages;

        // Assert if total records match the expected value
        int totalRecords = response.jsonPath().getInt("total");
        assert totalRecords == 12 : "Expected total records to be 12 but found " + totalRecords;
    }
}

