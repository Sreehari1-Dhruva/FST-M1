package Activities;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Activity1 {
	//Post https://petstore.swagger.io/v2/pet
	@Test(priority = 1)
	public void addPetRecord() {
		
		Map <String, Object> reqBody = new HashMap<>();
		reqBody.put("id", 996600);
		reqBody.put("name", "Tintin");
		reqBody.put("status","alive");
		
		//Create a response object

	Response response = 
		given().
			baseUri("https://petstore.swagger.io/v2/pet").
			header("Content-Type","application/json").
			body(reqBody).
		when().post();
	
	// Assertion
	response.then().body("id", equalTo(996600));
	response.then().body("name", equalTo("Tintin"));
	response.then().body("status", equalTo("alive"));
	
	}
	
	@Test(priority = 2)
	//GET https://petstore.swagger.io/v2/pet/{petId}
	public void getPetRecord() {
		Response response = given()
				.baseUri("https://petstore.swagger.io/v2/pet") // Set base URI
				.header("Content-Type", "application/json") // Set headers
				.when().pathParam("petId", 996600) // Set path parameter
				.get("/{petId}"); // Send GET request
	 
			// Assertion
			response.then().body("id", equalTo(996600));
			response.then().body("name", equalTo("Tintin"));
			response.then().body("status", equalTo("alive"));
	}
	
	//Delete https://petstore.swagger.io/v2/pet/{petId}
	@Test(priority = 3)
	public void deletePetRecord() {
		
		Response response = given()
			.baseUri("https://petstore.swagger.io/v2/pet") // Set base URI
			.header("Content-Type", "application/json") // Set headers
			.when().pathParam("petId", 996600) // Set path parameter
			.delete("/{petId}"); // Send DELETE request
 
		// Assertion
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo("996600"));
	}
	
}
