package Day7;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentications {
	
	//@Test(priority=1)
	void basic_authentication()
	{
		
		given()
			//Basic authentication
			.auth().basic("postman","password")
			
			//Digest Authentication
			//.auth().digest("postman","password")
			
			//Preemptive Authentication
			//.auth().preemptive().basic("postman","password")
			
		.when()
			.get("https://postman-echo.com/basic-auth")
		.then()
			.statusCode(200)
			.body("authenticated",equalTo(true))
			.log().all();
	}
	
	//Bearer Token Authentication
	//@Test
	void BearerToken_authentication()
	{
		String bearertoken = "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";
		
		given()	
			.headers("Authorization","Bearer "+bearertoken)
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	
	//OAuth 1 Authentication
	//@Test
	void OAUTH_1_authentication()
	{
		
		given()
			.auth().oauth("consumerKey", "consumerSecret", "accessToken", "tokenSecret")
			
		.when()
			.get("URL")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	//OAuth 2 Authentication
	//@Test
	void OAUTH_2_authentication()
	{
		
		given()
			.auth().oauth2("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")
			
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	//API key Authentication
	@Test
	void testapikey_authentication()
	{
		
		given()
			.queryParam("appid", "fe9c5cddb7e01d747b4611c3fc9eaf2c")
			
		.when()
			.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi")
		.then()
			.statusCode(200)
			.log().all();
	}

}
