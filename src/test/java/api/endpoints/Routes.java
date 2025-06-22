package api.endpoints;




public class Routes {
	  public static String base_url="https://petstore.swagger.io/v2" ;

	  //User module
	  public static String post_url = base_url+"/user" ;
	  public static String put_url = base_url+"/user/{username}" ; //here {username} is path parameter
	  public static String get_url = base_url+"/user/{username}" ;//first we have to create user and then we ave to send it to doff. endpoint
	  public static String delete_url = base_url+"/user/{username}" ;

	  
	  //store module

//	  public static String post_url = base_url+"/user" ;
//	  public static String put_url = base_url+"/user/{username}" ; //here {username} is path parameter
//	  public static String get_url = base_url+"/user/{username}" ;//first we have to create user and then we ave to send it to doff. endpoint
//	  public static String delete_url = base_url+"/user/{username}" ;
	  
	  
	  
	  //pet module
	  
	  
	  
	  
}
