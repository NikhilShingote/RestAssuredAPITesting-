package Day8;

import static io.restassured.RestAssured.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class DeleteUser {
	@Test
	void deleteuser(ITestContext context)
	{
		String bearerToken = "47777795f6a70e3c2ba97bc54528a681981b7ae7371c207a50209db8dc3375f5";
		int id = (int) context.getAttribute("user_id");
		given()
			.headers("Authorization","Bearer "+bearerToken)
			.pathParam("id", id)
			
		.when()
			.delete("https://gorest.co.in/public/v2/users/{id}")
			
		.then()
			.statusCode(204)
			.log().all();
	}

}
