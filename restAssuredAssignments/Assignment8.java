package restAssuredAssignments;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class Assignment8 {

	@Test(dataProvider="dataProv")
	  public void PostData(String fname, String Lname, String email) {
		  
		  JSONObject request=new JSONObject();
		  
		  request.put("first_name", fname);
		  request.put("last_name", Lname);
		  request.put("Email", email);
		  
		  
		  given()
			.header("Content Type", "Application/ JSON")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toString()).
		when()
			.post("https://reqres.in/api/users/2").
		then()
			.statusCode(201)
			.log()
			.all();
		  
		  
	  }
	  
	  
	  @DataProvider(name = "dataProv")
		public Object[] dataProv(){
		  return new Object[][] {
				{"Nishant", "Kumar", "nishant@email.com"},
				{"Henery", "Ford", "Henery@email.com"}
			};
		}

}