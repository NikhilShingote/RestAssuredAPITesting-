package Day7;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class Faker_datagenerator {
	
	@Test
	void OAUTH_2_authentication()
	{
		Faker faker = new Faker();
		//We can generate fake data from faker object
		String fullname = faker.name().fullName();
		String firstname = faker.name().firstName();
		String lastname = faker.name().lastName();
		String username = faker.name().username();
		String password = faker.internet().password();
		String number = faker.phoneNumber().cellPhone();
		String emailid = faker.internet().safeEmailAddress();
		
		System.out.println("fullname: "+fullname);
		System.out.println("firstname: "+firstname);
		System.out.println("lastname: "+lastname);
		System.out.println("username: "+username);
		System.out.println("password: "+password);
		System.out.println("number: "+number);
		System.out.println("emailid: "+emailid);
	}
	

}
