package day2;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
/*different ways to create post request body
1. Using HashMap
2. using Org.json
3. Using POJO
4. By using External json file*/

public class DiffWaysToPostReqBoday {
	// 1) Post Request Using HashMap

	// @Test (priority=1)
	void testPostUsingHashMap() {
		HashMap data = new HashMap();
		data.put("name", "sam");
		data.put("age", "18");
		data.put("grade", "12");
		data.put("email", "sam@gmail.com");

		String courseArr[] = { "C", "C++" };
		data.put("courses", courseArr);

		given().contentType("application/json").body(data)

				.when().post("http://localhost:3000/students")

				.then().statusCode(201).body("name", equalTo("sam")).body("age", equalTo("18"))
				.body("grade", equalTo("12")).body("email", equalTo("sam@gmail.com")).body("courses[0]", equalTo("C"))
				.body("courses[1]", equalTo("C++")).header("Content-Type", "application/json; charset=utf-8").log()
				.all();

	}

	@Test(priority = 2)
	void testDelete() {
		given()

				.when().delete("http://localhost:3000/students/8")

				.then().statusCode(200).log().all();
	}

}
