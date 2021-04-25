import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;


public class Delete_Request {
	@Test
	public void deleteEmployeeRecord()
	{
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/2";
		
		Response response = 
		
		given()
		
		.when()
		   .delete()
		
		.then()
		   .statusCode(200)
		   .statusLine("HTTP/1.1 200 OK")
		   .log().all()
		   .extract().response();
		
	    	String jsonAsString = response.asString();
	    	System.out.println(jsonAsString);
	    	Assert.assertEquals(jsonAsString.contains("Successfully! Record has been deleted"), true);
		  
}

	
}
