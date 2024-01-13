package Day3;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PathandQueryParameters {
	
	@Test
	void testqueryandpathparams()
	{
		given()
			// here now the prerequisites are path parameter and query parameters
			//Path parameters
			.pathParam("mypath","users")
			//Query parameters	
			.queryParam("page",2)
			.queryParam("id",5)
		
		.when()
			.get("https://reqres.in/api/{mypath}")
		
		.then()
			.statusCode(200)
			.log().all();
		
	}
	

}
