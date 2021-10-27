package restAssuredAssignments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;

import org.junit.Test;

public class Assignment5 {
	
	@Given("API for foreign exchange")
	public void api_for_foreign_exchange() {

//	baseURI = "http://api.exchangeratesapi.io/v1/latest?access_key=28cb6ca63e295b5da43e3ce2ae79bedd";

	}
	
	@Test
	@When("posted with correct Information")
	public void posted_with_correct_information() {
		baseURI = "http://localhost:3000/users";
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).
		header("Content-Type","application/json").
		param("Dr.", "Strange").
		when().post("/users").
		then().log().all().statusCode(201);	
		
	}

	@Then("validate positive response code received")
	public void validate_positive_response_code_received() {
		baseURI = "http://localhost:3000/users";
		
		ResponseSpecification response = given().response();
		System.out.println(response);

	}
}
