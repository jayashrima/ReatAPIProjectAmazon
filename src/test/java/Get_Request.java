import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//- Get & Delete - Status code to be Successful.
//- Get - Return specific Employee details(Any).
//- Delete - "message": "successfully! deleted Records".
public class Get_Request {
	@Test
	public void employeeDetails() {
		RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/employee/4";
		
		Response response = given().when() .get().then()
		   .statusCode(200)
		   .statusLine("HTTP/1.1 200 OK")
		   .contentType("application/json")
		   .log().all()
		   .extract().response();
		
	    	String jsonAsString = response.asString();
	    	System.out.println(jsonAsString);
	    	Assert.assertEquals(jsonAsString.contains("Successfully! Record has been fetched."), true);
	}
	    	
	    	//@Test
			public void testEqualToFunctionVerifyId() {
				RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
				RestAssured.basePath="/employee/4";
				
				given().
				when().
				    get().
				then()
					.body("id", equalTo(4));
			}
			
			//@Test
			public void testEqualToFunctionVerifyName() {
				RestAssured.baseURI ="http://dummy.restapiexample.com/api/v1";
				RestAssured.basePath="/employee/4";
				
				given().
				when().
				    get().
				then().
				body("employee_name", equalTo("Cedric Kelly"));
			}
			
	
	
	}

	
	


