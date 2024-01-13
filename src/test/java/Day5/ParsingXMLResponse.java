package Day5;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.List;


// Approach 1
public class ParsingXMLResponse {
	
	//@Test(priority=1)
	void testXMLresponse()
	{

		//Approach 1
		
		/*given()
			
		
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1")
		
		.then()
			.statusCode(200)
			.header("Content-Type","application/xml; charset=utf-8")
			.body("TravelerinformationResponse.page",equalTo("1"))
			// using XPATH to validate name
			.body("TravelerinformationResponse.travelers.Travelerinformation[0].name",equalTo("Developer"));
		*/
		
		//Approach 2
		Response res = given()
			
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		Assert.assertEquals(res.getStatusCode(),200);
		Assert.assertEquals(res.header("Content-Type"),"application/xml; charset=utf-8");
		String pageno = res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pageno,"1");
		String traveler_name = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		Assert.assertEquals(traveler_name,"Developer");
		
			
	}
	
// Approach 2
	@Test(priority=1)
	void testXMLresponse2()
	{
		
		Response res = given()
			
		.when()
			.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		
		
		// if you want to convert data from the response into string then use toString()
		// if you want to convert the entire response into string then use asString()
		
		//Using XML path class(predefined class)
		XmlPath xmlobj = new XmlPath(res.asString());
		
		// if you want to capture all the travelers info then use this 
		List<String> travelers_info = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		Assert.assertEquals(travelers_info.size(),10);
		
		// to check if certain data is present in response
		List<String> traveler_names = xmlobj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		boolean status=false;
		for(String name:traveler_names)
		{
			if(name.equals("karen"))
			{
				status=true;
				break;
			}
		}
		Assert.assertEquals(status,true);
		
			
	}
}
