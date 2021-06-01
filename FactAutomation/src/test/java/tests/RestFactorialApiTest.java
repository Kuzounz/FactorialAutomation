package tests;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import utils.Groups;

public class RestFactorialApiTest {

	@Test(groups = {Groups.HEARTBEATAPI},description = "Verify that factorial of number is returning 200 with expected result ")
	public void APITestFactorialInteger() {
		Response res = given().formParam("number", "10").when().post("http://qainterview.pythonanywhere.com/factorial")
				.then().statusCode(200).log().body().extract().response();
		String jsonString = res.asString();
		Assert.assertEquals(jsonString.contains("3628800"), true);
	}

	@Test (groups = {Groups.HEARTBEATAPI},description = "Verify that sending String is return 500")
	public void APITestFactorialString() {
		given().formParam("number", "ThisIsAString").when().post("http://qainterview.pythonanywhere.com/factorial")
				.then().statusCode(500);
	}
}
