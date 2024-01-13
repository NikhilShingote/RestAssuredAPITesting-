package Day1_BasicRequests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

// given() (pre-requisies)
// content type, set cookies, add auth, add param, set headers info etc

// when()
// request types

// then()
// validations status code, responses etc
public class HttpRequests {
	
	//global variable to capture the id of user
	int id;
	
	@Test(priority=1)
	void getUsers()                          //GET
	{
		// We have to add static packages manually here
		//here actually given is 1 method which includes when() and further it includes then()
		// when you dont have any prerequisites and just want to send get request then you can remove given() and directly start with when(without ".")
		given()
		
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();  // printing the entire response
	}
	
	@Test(priority=2)
	void createUser()                     // POST 
	{
		
		HashMap hm = new HashMap();
		// lets add some data to hashmap
		hm.put("name","pavan");
		hm.put("job","trainer");
		
		id=given()
			//content type
			.contentType("application/json")
			//body
			.body(hm)
			
		.when()
			.post("https://reqres.in/api/users")
			//capturing the response id
			.jsonPath().getInt("id");
		
		//.then()
			//validation
			//.statusCode(201)
			//.log().all();

	}
	
	@Test(priority=3,dependsOnMethods = {"createUser"})   // creates on method checks if the above method is passed then only it will execute
	void updateUser()                   // UPDATE
	{
		HashMap hm = new HashMap();
		// lets add some data to hashmap
		hm.put("name","Nikhil");
		hm.put("job","tester");
		
		given()
			//content type
			.contentType("application/json")
			//body
			.body(hm)
			
		.when()
			.put("https://reqres.in/api/users/"+id)
		
		.then()
			//validation
			.statusCode(200)
			.log().all();

	}
	
	@Test(priority=4)
	void deleteUser()
	{
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
		.then()
			.statusCode(204);
	}

}
