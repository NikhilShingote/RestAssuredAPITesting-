package Day5;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class File_upload_download {
	
	//@Test
	void singlefileupload()
	{
		File myfile = new File("I:\\uploads\\Test_file_1.txt");
		
		given()
			.multiPart("file",myfile)
			.contentType("multipart/form-data")
			
		
		.when()
			.post("http://localhost:8080/uploadFile")
		
		.then()
			.statusCode(200)
			.body("fileName", equalTo("Test_file_1.txt"))
			.log().all();
	}
	
	@Test
	void multiplefileupload()
	{
		File myfile1 = new File("I:\\uploads\\Test_file_1.txt");
		File myfile2 = new File("I:\\uploads\\Test_file_2.txt");
		
		given()
			.multiPart("files",myfile1)
			.multiPart("files",myfile2)
			.contentType("multipart/form-data")
			
		
		.when()
			.post("http://localhost:8080/uploadMultipleFiles")
		
		.then()
			.statusCode(200)
			.body("[0].fileName", equalTo("Test_file_1.txt"))
			.body("[1].fileName", equalTo("Test_file_2.txt"))
			.log().all();
	}

}
