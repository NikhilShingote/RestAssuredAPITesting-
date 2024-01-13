package Day6;

// Serialization - POJO object converted to JSON object
//Deserialization - JSON object  converted to POJO object
// POJO is java object

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Day2.POJO_POSTrequest;

public class Serialization_Deserialization {
	
	//POJO to JSON - Serialization
	//@Test
	void convertPojotoJSON() throws JsonProcessingException
	{
		// this is our POJO class object
		Student data = new Student();
		// through data we can access all the setters and getters method
		data.setName("Nikhil");
		data.setLocation("Iran");
		data.setPhone("498521234");
		//we need to create an array of course names to add it in courses field
		String coursesArr[] = {"C#","Java"};
		// adding the above array to courses field
		data.setCourses(coursesArr);
		
		//Serialization
		//now we need to convert this pojo object into JSON object
		ObjectMapper objmapper = new ObjectMapper();
		String jsondata = objmapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		System.out.println(jsondata);
	}
	
	//JSON to POJO - (De-Serialization)
	@Test
	void convertJSONtoPOJO() throws JsonProcessingException
	{
		//Converting jsondata into POJO object
		String jsondata = "{\r\n"
				+ "  \"name\" : \"Nikhil\",\r\n"
				+ "  \"location\" : \"Iran\",\r\n"
				+ "  \"phone\" : \"498521234\",\r\n"
				+ "  \"courses\" : [ \"C#\", \"Java\" ]\r\n"
				+ "}";
		
		//Serialization
		//now we need to convert this pojo object into JSON object
		ObjectMapper objmapper = new ObjectMapper();
		Student stupojo = objmapper.readValue(jsondata, Student.class);
		
		//getting the data from this above object
		System.out.println("name:"+stupojo.getName());
		System.out.println("location:"+stupojo.getLocation());
		System.out.println("phone:"+stupojo.getPhone());
		System.out.println("course1:"+stupojo.getCourses()[0]);
		System.out.println("course2:"+stupojo.getCourses()[1]);
	}

}
