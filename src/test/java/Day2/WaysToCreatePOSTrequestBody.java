package Day2;

import org.json.JSONObject;
import org.json.JSONTokener;

//Different ways to create POST request body
// 1. Using HashMap
// 2. Org.JSON
// 3. Using POJO class
// 4. Using External JSON file data

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;


public class WaysToCreatePOSTrequestBody {
	
	// Method 1
	// 1. Using HashMap
	
	//@Test(priority=1)
	void testPOSTusingHashMap()
	{
		HashMap data = new HashMap();
		data.put("name","Pratik");
		data.put("location","France");
		data.put("phone","947278219");
		
		//we need to create an array of course names to add it in courses field
		String courseArr[] = {"python","json"};
		// adding the above array to courses field
		data.put("courses", courseArr);
		
		given()
			.contentType("application/json")
			// Passing the data into the body directly
			.body(data)
		
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			// Validation
			.statusCode(201)
			.body("name",equalTo("Pratik"))
			.body("location",equalTo("France"))
			.body("phone",equalTo("947278219"))
			.body("courses[0]",equalTo("python"))
			.body("courses[1]",equalTo("json"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
			
		
	}
	
	// Method 2
	// 2. POST request body using Org.JSON library
	// For this we require to add org.json dependency in POM.xml file 
	//@Test(priority=1)
	void testPOSTusingJSONlibrary()
	{
		// first we have a predefined class JSONObject and we need to create an object of that
		JSONObject data = new JSONObject();
		data.put("name","Scott");
		data.put("location","Italy");
		data.put("phone","498521234");
		//we need to create an array of course names to add it in courses field
		String coursesArr[] = {"C","R"};
		// adding the above array to courses field
		data.put("courses", coursesArr);
		
		
		
		given()
			.contentType("application/json")
			// Here in Org.json we cannot pass data directly into body
			// we have to first convert data into string format
			.body(data.toString())
		
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			// Validation
			.statusCode(201)
			.body("name",equalTo("Scott"))
			.body("location",equalTo("Italy"))
			.body("phone",equalTo("498521234"))
			.body("courses[0]",equalTo("C"))
			.body("courses[1]",equalTo("R"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
			
		
	}
	
	// Method 3
	// 3. POST request body using POJO class
	// Now we have to assign the data and retrieve data for every variable
	// for this we have to write getters and setters
	// @Test(priority=1)
	void testPOSTusingPOJOclass()
	{
		// first we have to create a new class in package Day2
		
		POJO_POSTrequest data = new POJO_POSTrequest();
		// through data we can access all the setters and getters method
		data.setName("Nikhil");
		data.setLocation("Iran");
		data.setPhone("498521234");
		//we need to create an array of course names to add it in courses field
		String coursesArr[] = {"C#","Java"};
		// adding the above array to courses field
		data.setCourses(coursesArr);
		
		
		
		given()
			.contentType("application/json")
			.body(data)
		
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			// Validation
			.statusCode(201)
			.body("name",equalTo("Nikhil"))
			.body("location",equalTo("Iran"))
			.body("phone",equalTo("498521234"))
			.body("courses[0]",equalTo("C#"))
			.body("courses[1]",equalTo("Java"))
			.header("Content-Type","application/json; charset=utf-8")
			.log().all();
			
		
	}
	
		// Method 4
		// 3. POST request body using external JSON file
		@Test(priority=1)
		void testPOSTusingexternalJSON() throws FileNotFoundException
		{
			// first open the file
			File f = new File(".\\body.json");
			// from this f object if we want to read the data we have use 2 more class
			FileReader fr = new FileReader(f);
			JSONTokener jt = new JSONTokener(fr);
			JSONObject data = new JSONObject(jt);
			
			
			
			given()
				.contentType("application/json")
				.body(data.toString())
			
			
			.when()
				.post("http://localhost:3000/students")
			
			.then()
				// Validation
				.statusCode(201)
				.body("name",equalTo("John"))
				.body("location",equalTo("india"))
				.body("phone",equalTo("1234567890"))
				.body("courses[0]",equalTo("Java"))
				.body("courses[1]",equalTo("Selenium"))
				.header("Content-Type","application/json; charset=utf-8")
				.log().all();
				
			
		}
	
	// Delete record
	@Test(priority=2)
	void testDELETErecord()
	{
		given()
		
		
		.when()
			.delete("http://localhost:3000/students/4")
		
		.then()
			.statusCode(200);
		
	}

}
