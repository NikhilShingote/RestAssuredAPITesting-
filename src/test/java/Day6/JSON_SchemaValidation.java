package Day6;

//to convert json to json schema we need to use an online converter
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

//Response validation Vs Schema validation
// 1. Response validation - we validate the data
// 2. Schema validation - we validate the type of data

public class JSON_SchemaValidation {
	
	@Test
	void schemavalidation()
	{
		// we need to first maintain json schema(.json) file into resources
		// after that we have to capture the json response(.json)
		given()
		
		
		
		.when()
			.get("http://localhost:3000/store")
		
			
		.then()
			// schema validation
			.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Store_JSON_Schema.json"));
		
	}
	
}
