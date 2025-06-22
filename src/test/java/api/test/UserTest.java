package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {
	
	Faker faker;  //by using faker library we can create required data i.e int id; username ;firstName;lastName ;email;password;phone;userStatus 
	User userpayload ;              // and also parallaly we have to send data in pojo Set() method
	
	@BeforeClass
	public void setupData()
	
	{
	  faker = new Faker();	
	  userpayload = new User(); //Once faker create data, this userpayload having this all data, So we have to pass this userpayload in every test i.e in post, put request
	  
	  userpayload.setId(faker.idNumber().hashCode()); //hashCode() method will create new id everytime.
	  userpayload.setFirstName(faker.name().firstName());
	  userpayload.setLastName(faker.name().lastName());
	  userpayload.setEmail(faker.internet().emailAddress());
	  userpayload.setPassword(faker.internet().password());
	  userpayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test(priority=1)   //user the Test we just calling end point (i.e.UserEndpoint.createUser) by passing required input(i.e.userpayload), so this payload (response) will go to UserEndPoint and perform action
	
	public void testPostUser()
	{
		 Response response =  UserEndPoints.createUser(userpayload);
		 response.then().log().all();
		 Assert.assertEquals(response.getStatusCode(), 200);
		 
	}
	
//	@Test(priority=2)
//	public void testPutUser()
//	{
//		
//		
//	}
	
	@Test(priority=2)
	public void testGetUser()
	{
		 Response response =  UserEndPoints.readUser(this.userpayload.getUsername());
		 response.then().log().all();
		 //response.statusCode();
		 Assert.assertEquals(response.statusCode(), 200);
	}
	
	

}
