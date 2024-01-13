package Day3;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class Headers {
	
	//@Test(priority=1)
	void testheaders()
	{
		given()
		
		
		
		.when()
			.get("https://www.google.com/")
		
		
		.then()
			//to validate headers
			.header("Content-Type","text/html; charset=ISO-8859-1")
			.header("Content-Encoding","gzip");
		
		
	}
	
	@Test(priority=2)
	void getheaders()
	{
		Response res = given()
		
		.when()
			.get("https://www.google.com/");
		
		
		//get single header info
		//String header_value = res.getHeader("Content-Type");
		//System.out.println("Value of single header is:"+header_value);
		
		//get all headers info
		io.restassured.http.Headers myheaders = res.getHeaders();
		
		for(Header hd:myheaders)
		{
			System.out.println(hd.getName()+"  "+hd.getValue());
		}
		
		
	}

}
