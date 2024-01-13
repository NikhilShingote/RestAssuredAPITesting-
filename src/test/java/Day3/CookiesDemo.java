package Day3;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesDemo {
	
	//@Test(priority=1)
	void testcookies()
	{
		given()
		
		
		
		.when()
			.get("https://www.google.com/")
		
		
		.then()
			//to validate a cookie
		//since the cookie value always change which indicates it generates cookie so our test case passes
			.cookie("AEC","Ad49MVG3wdrtcNK9KnRnsO_Ul29D1sRnswbmcavkoRcqRcQRuhcf3DSbDA")
			//to see all responses
			.log().all();
		
		
	}
	
	@Test(priority=2)
	void capturecookiesinfo()  
	{
		// capturing the entire response in a variable
		// Response is a type of variable
		Response res = given()
		
		.when()
			.get("https://www.google.com/");
		
		//getting single cookie info and storing it in variable
		//String cookieValue = res.getCookie("AEC");
		//System.out.println("Value of cookie is: "+cookieValue);
		
		//getting All cookies info and storing it in variable since it contains data in key value pair
		//Map is HashMap
		Map<String,String> allcookie_values = res.getCookies();
		
		// Gives all Keys names
		System.out.println(allcookie_values.keySet());
		
		//We need to use loop to get values of all headers
		for(String key:allcookie_values.keySet())
		{
			String cookieValue = res.getCookie(key);
			System.out.println(key+"  "+cookieValue);
		}
		
		//alternate code is .log().Headers();
	}

}
