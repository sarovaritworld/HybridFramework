
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;


public class Demo {
	
	@Test (priority=1)
	void testPostUsingHashMap() {
		HashMap data = new HashMap();
		

		given().contentType("application/json").body(data)

				
	}

	
}
