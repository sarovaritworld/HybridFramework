package day3;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CookiesDemo {	
	@Test
	void testCookiesDemo(){
		given()
		
		.when()
			.get("https://www.google.com")
		
		.then()
			.cookie("AEC","sdhfkjhd")
			.log().all();
				
	}

}
