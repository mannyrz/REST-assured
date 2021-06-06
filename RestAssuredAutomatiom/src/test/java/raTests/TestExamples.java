package raTests;

import org.testng.Assert;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
//import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.ResponseAwareMatcher.*;
import static org.hamcrest.Matchers.*;

public class TestExamples {
	
	
	@Test
	public void test_1() {
		
		// Lesson One : 
		//https://www.udemy.com/course/rest-assured-java-framework-step-by-step-for-beginners/learn/lecture/24123340#overview
		
		Response response = get("https://reqres.in/api/users?page=2");
		//Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		System.out.println(response);
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test
	public void test_2() {
		
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data.id[1]", equalTo(8))
			.log().all();
		
		
	}

}
