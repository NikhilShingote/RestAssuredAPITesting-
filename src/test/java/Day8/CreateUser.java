package Day8;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

public class CreateUser {
	
	@Test
	void createuser(ITestContext context)  // through this context variable you can make it available for other different classes as well
	{
		//Creating data
		Faker faker = new Faker();
		
		//create request body
		JSONObject data = new JSONObject();
		data.put("name",faker.name().fullName());
		data.put("gender","Male");
		data.put("email",faker.internet().emailAddress());
		data.put("status","inactive");
		
		String bearerToken = "47777795f6a70e3c2ba97bc54528a681981b7ae7371c207a50209db8dc3375f5";
		
		//bearertoken we mostly pass with headers
		
		int id = given()
			.headers("Authorization","Bearer "+bearerToken)
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
		
		System.out.println("Generated id is: "+id);
		
		context.setAttribute("user_id", id); // setting the id value here(similar to creating an environment variable)
	}
}
