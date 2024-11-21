package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

/*
 	
given()
		Pre-requiste - content-type, set cookies, add auth, headers etc..
when()
		get, post, put, delete
then()
		all validations, status, body etc

*/

public class HTTPRequest {
	int id;

	@Test
	void getUser() {
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=1")
		
		.then()
			.statusCode(200)
			.body("page", equalTo(1))
			.log().all();
		
	}

	@Test (priority=1)
	void createUser() {
		HashMap data = new HashMap();
		data.put("name", "nammu");
		data.put("job", "Dev");
		
		
		
		id=given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		

/*		.then()
			.statusCode(201)
			.log().all();*/
		
	}
	@Test (priority =2, dependsOnMethods= {"createUser"})
	void updateUser(){
	
		HashMap data = new HashMap();
		data.put("name", "updatedName");
		data.put("job", "updatedJob");
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.put("https://reqres.in/api/users/"+id)
		
		.then()
		.statusCode(200)
		.log().all()
		;
		
	}
	@Test (priority=3)
	void deleteUser() {
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(204)
			.log().all();
		
	}
}
