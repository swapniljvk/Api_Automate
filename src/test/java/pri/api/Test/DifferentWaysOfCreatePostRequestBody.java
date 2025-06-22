package pri.api.Test;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class DifferentWaysOfCreatePostRequestBody {
//	@Test (priority=1)
	public void HashNap()
	{
		HashMap data = new HashMap();
			data.put("name", "rajesh");
			data.put("Lname", "patil");
		//	data.put("location", "sangli")
	        data.put("phone", "9877797");
	        
	        String values[] = {"chemical","RnD","Superwiser"};
	        data.put("cources", values);
		 
	        given()
	         .contentType("application/json")
	         .body(data)
	         
	        		 
	        .when()
	        .post("http://localhost:3000/Student")
	        
	        .then()
		    .statusCode(201)
		    .log().all();
		
	}
	//delete record
//	@Test (priority=2)
	void DeleteRecord()
	{
		
		given()
		
		.when()
          .delete("http://localhost:3000/Student/e6b4")		
		.then()
		 .statusCode(200)
		 .log().all();
		
		}

	//Post Request by using json.org library
	
	@Test (priority=3)
	
	void jsonlibrary ()
	{
		JSONObject data = new JSONObject();
		data.put("name", "json");
		data.put("Lname", "patil");
		//	data.put("location", "sangli")
	        data.put("phone", "9877797");
	        
	        String values[] = {"chemical","RnD","Superwiser"};
	        data.put("cources", values);
		
		given()
		 .contentType("application/json")
		 .body(data.toString())
		.when()
		.post("http://localhost:3000/Student")
		
		.then()
	    .statusCode(201);
	
	
	}
	
	//post request by using external json file
	 
	@Test (priority=4)
	void PostbyExternalJson() throws FileNotFoundException
	{
		//import some packages from java.io package
		File f = new File(".//body.json");  //here . represent current project
		 FileReader fr = new FileReader(f);
		//json tockner and JSONObject from org.json
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		given()
		 .contentType("application/json")
		 .body(data.toString())
		
		.when()
		 .post("http://localhost:3000/Student")
		
		.then()
           .statusCode(201)
           .log().all()	;	
		
		
		
		
	}
	
	
	
	
}
