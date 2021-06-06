package raTests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

//Lesson Two:

public class GetAndPostExamples {

	//@Test
	public void testGet() {
		
		//Lesson 2:
		
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("George", "Rachel"));
		
	}
	
	@Test
	public void testPost() {
		
//		//Map<K,V> map = new HashMap<k,V>()
//		Map<String,Object> map = new HashMap<String,Object>();
//		
//		map.put("name", "Manuel");
//		map.put("job", "Teacher");
//		
//		System.out.println(map);
//		
//		JSONObject myJsonObj = new JSONObject(map);
		
		//More simple version
		@SuppressWarnings("unused")
		Map<String,Object> map = new HashMap<String,Object>();
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Manuel");
		request.put("job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
		
	}
	
	
}
