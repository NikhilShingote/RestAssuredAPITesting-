package Day8;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {
	
	@Test
	void getuser(ITestContext context)
	{
		int id = (int) context.getAttribute("user_id");   // this should come from createuser class
		String bearerToken = "47777795f6a70e3c2ba97bc54528a681981b7ae7371c207a50209db8dc3375f5";
		given()
			.headers("Authorization","Bearer "+bearerToken)
			.pathParam("id", id)
		
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
			.statusCode(200)
			.log().all();
	}

}
