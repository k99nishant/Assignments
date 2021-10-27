package restAssuredAssignments;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;

import org.json.*;

public class Assignment1 {

//	@Given("API for foreign exchange")
	public void api_for_foreign_exchange() {
		//baseURI= "\"https://reqres.in/api/users";

	}

//	@When("posted with correct Information")
	public void posted_with_correct_information() {

//		baseURI = "https://reqres.in/api/users";
		baseURI = "http://localhost:3000/users";
		JSONObject request = new JSONObject();
		request.put("name", "leader");
		request.put("job", "leader");

		given().
			body(request.toString()).post().
		then().
			assertThat().statusCode(201).log().all();
		
		
		
	}

//	@Then("validate positive response code received")
	public void validate_positive_response_code_received() {
		
	}

}