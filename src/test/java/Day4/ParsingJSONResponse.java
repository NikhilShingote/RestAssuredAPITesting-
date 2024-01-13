package Day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJSONResponse {
	
	//@Test(priority=1)
	void testJSONResponse()
	{
		//Approach 1
		/*
		given()
			.contentType(ContentType.JSON)
		
		.when()
			.get("http://localhost:3000/store")
		
		.then()
			.statusCode(200)
			.header("Content-Type","application/json; charset=utf-8")
			.body("book[3].title",equalTo("The Lord of the Rings"));
		
		
		//Approach 2
		Response res = given()
			.contentType(ContentType.JSON)
	
		.when()
			.get("http://localhost:3000/store");
		//Validations on response variable where we stored the response
		// so basically we can do validations using then() or by capturing the response in a variable and then do validations
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
		String bookname = res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(bookname,"The Lord of the Rings");*/
	}
	
	@Test(priority=2)
	void testJSONResponsebodydata()
	{
		//Approach 2
		// from each object we need to capture the title
		// we need to use the JSONObject class(predefined class)
		Response res = given()
			.contentType(ContentType.JSON)
	
		.when()
			.get("http://localhost:3000/store");
		//Validations on response variable where we stored the response
		// so basically we can do validations using then() or by capturing the response in a variable and then do validations
		/*Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
		String bookname = res.jsonPath().get("book[3].title").toString();
		Assert.assertEquals(bookname,"The Lord of the Rings");*/
		
		//JSONObject expects the response variable in String format(JSON object type)
		// but the res variable is in in Response format
		JSONObject jo = new JSONObject(res.toString());
		
		for(int i=0;i<jo.getJSONArray("book").length();i++)
		{
			String book_title = jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			System.out.println(book_title);
		}
		
	}

}
