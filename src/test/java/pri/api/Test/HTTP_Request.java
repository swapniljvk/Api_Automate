package pri.api.Test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
// https://reqres.in/
public class HTTP_Request {
@Test(priority=1)

void getListUser() 
{
      given()
      
      .when().get("https://reqres.in/api/users?page=2")
      
      .then().statusCode(200)
      .body( "page",equalTo(2))
      .log().all();
      }

@Test(priority=2)

  void getSingleUser()
  {
	given()
	
	.when()
	 .get("https://reqres.in/api/users/2")
	// .header("x-api-key","reqres-free-v1")
	
	.then()
	 .statusCode(200)
	 //.body("data/id",equalTo(2))
	 .log().all()	;
	
  }
int id;
@Test (priority=3)
 
void createUser() 

{
	HashMap data = new HashMap();
      data.put("name", "Swapnil");
      data.put("job", "IT");
      
      id= given()
       .contentType("application/json")
       .body(data)
        .header("x-api-key","reqres-free-v1")
     
       .when()
       .post("https://reqres.in/api/users")
       .jsonPath().getInt("id");
      
//       .then()
//         .statusCode(201)
//         .log().all();

	}
@Test (priority=4, dependsOnMethods= {"createUser"})

	void updateUser()
	{	
	HashMap data = new HashMap();
	data.put("name", "ND");
	data.put("job", "Dukandar");
	
	
	given()
   .contentType("application/json")
   .body(data)
  .header("x-api-key","reqres-free-v1")
   
   .when()
    .put("https://reqres.in/api/users/"+id)
    
   
   .then()
   
    .statusCode(200)
     .log().all();
}

@Test (priority=5)

void deleteUser()
{
	given()
     .header("x-api-key","reqres-free-v1")
	
	.when()
	.delete("https://reqres.in/api/users/"+id)

	.then()		
	 .statusCode(204)
	 .log().all();
}



}


