package Day8;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {
	
	@Test
	void updateuser(ITestContext context)
	{
		//Updating data
		Faker faker = new Faker();
		
		//create request body
		JSONObject data = new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("gender","Female");
		data.put("email",faker.internet().emailAddress());
		data.put("status","active");
		
		String bearerToken = "47777795f6a70e3c2ba97bc54528a681981b7ae7371c207a50209db8dc3375f5";
		
		int id = (int) context.getAttribute("user_id");
		
		given()
			.headers("Authorization","Bearer "+bearerToken)
			.contentType("application/json")
			.pathParam("id", id)
			.body(data.toString())
			
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
			
		.then()
			.statusCode(200)
			.log().all();
		
		
		System.out.println("Generated id is: "+id);
	}
}
