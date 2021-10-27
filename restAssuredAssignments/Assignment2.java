package restAssuredAssignments;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.junit.Test;

import io.restassured.specification.ResponseSpecification;

public class Assignment2 {
	
	@Test
	public void validateResponse() {

		baseURI = "http://localhost:3000/users";
		ResponseSpecification response = given().when().then().statusCode(200).log().all();
		System.out.println("Response is " + response);
	}

}