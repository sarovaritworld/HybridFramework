package day2;

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



//import org.json.JSONObject;
//import org.json.JSONTokener;
//import org.testng.annotations.Test;
//import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
//import static org.hamcrest.Matchers.*;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.util.HashMap;
///*different ways to create post request body
//1. Using HashMap
//2. using Org.json
//3. Using POJO
//4. By using External json file*/
//
//public class DiffWaysToPostReqBoday {
//	// 1) Post Request Using HashMap
//
//	// @Test (priority=1)
//	void testPostUsingHashMap() {
//		HashMap data = new HashMap();
//		
//
//		given().contentType("application/json").body(data);
//
//				
//	}
//
//	// 2) Post Request body using org.json Library
//
//	// @Test (priority=1)
//	void testPostUsingOrgJson() {
//
//		JSONObject data = new JSONObject();
//		data.put("name", "sam");
//		data.put("age", "18");
//		data.put("grade", "12");
//		data.put("email", "sam@gmail.com");
//
//		String coursesArr[] = { "C", "C++" };
//		data.put("courses", coursesArr);
//
//		given().contentType("application/json").body(data.toString())
//
//				.when().post("http://localhost:3000/students")
//
//				.then().statusCode(201).body("name", equalTo("sam")).body("age", equalTo("18"))
//				.body("grade", equalTo("12")).body("email", equalTo("sam@gmail.com")).body("courses[0]", equalTo("C"))
//				.body("courses[1]", equalTo("C++")).header("Content-Type", "application/json; charset=utf-8").log()
//				.all();
//
//	}
//
//	// 3) Post Request body using POJO (Plain Old java object)
//
////	@Test(priority = 1)
//	void testPostUsingPOJO() {
//
//		Pojo_PostRequest data = new Pojo_PostRequest();
//
//		data.setName("sam");
//		data.setAge("18");
//		data.setGrade("12");
//		data.setEmail("sam@gmail.com");
//
//		String coursesArr[] = { "C", "C++" };
//		data.setCourses(coursesArr);
//
//		given().contentType("application/json").body(data)
//
//				.when().post("http://localhost:3000/students")
//
//				.then().statusCode(201).body("name", equalTo("sam")).body("age", equalTo("18"))
//				.body("grade", equalTo("12")).body("email", equalTo("sam@gmail.com")).body("courses[0]", equalTo("C"))
//				.body("courses[1]", equalTo("C++")).header("Content-Type", "application/json; charset=utf-8").log()
//				.all();
//
//	}
//
//	// 4) Post Request body using using External file
//
//	@Test(priority = 1)
//	void testPostUsingExternalJsonFile() throws FileNotFoundException {
//		
//		File f = new File(".\\body.json");
//		
//		FileReader fr = new FileReader(f);
//		
//		JSONTokener jt = new JSONTokener(fr);
//		
//		JSONObject data = new JSONObject(jt);
//		
//	
//		given().contentType("application/json").body(data.toString())
//
//				.when().post("http://localhost:3000/students")
//
//				.then().statusCode(201).body("name", equalTo("sam")).body("age", equalTo("18"))
//				.body("grade", equalTo("12")).body("email", equalTo("sam@gmail.com")).body("courses[0]", equalTo("C"))
//				.body("courses[1]", equalTo("C++")).header("Content-Type", "application/json; charset=utf-8").log()
//				.all();
//
//	}
//
//
//
//	@Test(priority = 2)
//	void testDelete() {
//		given()
//
//				.when().delete("http://localhost:3000/students/10")
//
//				.then().statusCode(200).log().all();
//	}
//
//}
