package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//userendpoints.java  created for CRUD operation to the user API

public class UserEndPoints {

	 public static Response createUser(User payload)  //import User from api.payload
	 {
		
		  Response response = given()
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON )
		      .body(payload)
		.when()
		   .post(Routes.post_url);
	     
		    return response ;
	}


	 public static Response readUser(String userName )  //this is get request we are not taking any data from Payload
	 {
		
		  Response response = given()   //here no body we r not accepting anything,    As a given() we are passing here path parameter
		           .pathParam("username", userName )
		.when()
		   .get(Routes.get_url);
	     
		    return response ;
	}
	 
	 public static Response updateUser(String userName, User payload)  //toupdate details we need 1.who's data we want to update i.e. userName, and which data want to update i.e. user ka payload
	 {                                       //  same way if we want to update store or pet's data then we have to pass (store payload),Or (pet payload)       
		
		  Response response = given()
		      .contentType(ContentType.JSON)
		      .accept(ContentType.JSON )
		      .pathParam("username", userName)
		      .body(payload)
		.when()
		   .put(Routes.put_url);
	     
		    return response ;
	}
	 
	 public static Response deleteUser(String userName)
	 {
		
		  Response response = given()
		      .pathParam("username", userName)
		   .when()
		   .delete(Routes.delete_url);
	     
		    return response ;
	}
	 
	 
	 
	 

}
