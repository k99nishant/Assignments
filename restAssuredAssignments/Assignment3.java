package restAssuredAssignments;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;

public class Assignment3 {
	@Test
	public void validateRespStatusCode() {
		
		
		RestAssured.baseURI = "http://localhost:3000/users";
		
		int expectedStatusCode = RestAssured.given().get().getStatusCode();
		
		System.out.println("Status Code : " + expectedStatusCode);
		
		Assert.assertEquals(expectedStatusCode, 200);
		
	}

}
