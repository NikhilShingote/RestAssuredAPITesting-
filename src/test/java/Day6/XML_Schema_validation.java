package Day6;
//to convert xml to xml schema we need to use an online converter
import org.testng.annotations.Test;

import io.restassured.matcher.RestAssuredMatchers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class XML_Schema_validation {
	
	@Test
	void xmlschemavalidation()
	{
		// we need to first maintain xml schema file into resources
		// after that we have to capture the xml response(.xml) and compare it with xml schema(.xsd)
		given()
		
		
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler")
		
			
		.then()
			// schema validation
			.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("Traveler.xsd"));
	}
}
