package day4;

import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FetchJSOValue {
	
	String Token = "eyJ0eXAiOiJKV1QiLCJub25jZSI6ImloaUpNaExqRUV1RVRIRDhEYUhfVlVTUXpoMFl4WTZGay1mSlYxSjU1TzAiLCJhbGciOiJSUzI1NiIsIng1dCI6IkhTMjNiN0RvN1RjYVUxUm9MSHdwSXEyNFZZZyIsImtpZCI6IkhTMjNiN0RvN1RjYVUxUm9MSHdwSXEyNFZZZyJ9.eyJhdWQiOiJodHRwczovL2dyYXBoLm1pY3Jvc29mdC5jb20iLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC9lYmRmMGU0Yy1lYmUyLTQ3OTMtYWY1Mi1jZWFmOTZmODI3NDEvIiwiaWF0IjoxNzU4ODAyNDAwLCJuYmYiOjE3NTg4MDI0MDAsImV4cCI6MTc1ODgwNjMwMCwiYWlvIjoiazJSZ1lMaXQxYjc1NGw3ZFI1ZlVWdlJNKzZ0K0ZnQT0iLCJhcHBfZGlzcGxheW5hbWUiOiJNU0dyYXBoQXBwIiwiYXBwaWQiOiJmZmE2ZDllZi1iY2RkLTQ0ODktOGE5ZC04NzQ2Y2E5NjFjMWMiLCJhcHBpZGFjciI6IjEiLCJpZHAiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC9lYmRmMGU0Yy1lYmUyLTQ3OTMtYWY1Mi1jZWFmOTZmODI3NDEvIiwiaWR0eXAiOiJhcHAiLCJvaWQiOiJmZTg3YjU0Ni1iNDM0LTQ4OTYtYThkMy0wMWFlN2EzYTYzZDAiLCJyaCI6IjEuQWJFQVRBN2Y2LUxyazBldlVzNnZsdmduUVFNQUFBQUFBQUFBd0FBQUFBQUFBQUN4QUFDeEFBLiIsInJvbGVzIjpbIlVzZXIuUmVhZFdyaXRlLkFsbCIsIkFwcGxpY2F0aW9uLlJlYWRXcml0ZS5BbGwiLCJVc2VyLlJlYWQuQWxsIiwiQXBwUm9sZUFzc2lnbm1lbnQuUmVhZFdyaXRlLkFsbCJdLCJzdWIiOiJmZTg3YjU0Ni1iNDM0LTQ4OTYtYThkMy0wMWFlN2EzYTYzZDAiLCJ0ZW5hbnRfcmVnaW9uX3Njb3BlIjoiRVUiLCJ0aWQiOiJlYmRmMGU0Yy1lYmUyLTQ3OTMtYWY1Mi1jZWFmOTZmODI3NDEiLCJ1dGkiOiJpaUY2OVVtdXgwQ2NET0VrbXk5OUFRIiwidmVyIjoiMS4wIiwid2lkcyI6WyIwOTk3YTFkMC0wZDFkLTRhY2ItYjQwOC1kNWNhNzMxMjFlOTAiXSwieG1zX2Z0ZCI6IjJzS214VEoyX18zMWgyblFpLUctZHBoYW8wb1VhT19LYkJFM0hHdFJrSVVCYzNkbFpHVnVZeTFrYzIxeiIsInhtc19pZHJlbCI6IjcgMTIiLCJ4bXNfcmQiOiIwLjQyTGpZQkppMnNnb0pNTEJMaVNRT3lfOTJ2UF9SZzU3RXJJRXIwd1JfUWNVNVJRU3lFaDg1RmlkdThsdGMtTGJ5dXd0YWh1QW9oeENBc3dNRUhBQVNnTUEiLCJ4bXNfdGNkdCI6MTcwNjE4MzQ2MX0.dfvkpPzZXmr2UOaeT1whorjeHF6t5aPVuWM99n1-xrwIEoYxGvzteQaFY8d7GuBye8gnVa61b-omUSqP3yhRLMm1FmUezg-QfjdFzsEhPmsPOeK2h8iNsbw3kXiL4k_beY4v1wUJZ3eEMLeAZ6jD2P2SzK7cApnhTClIluJbA4W-AHV4WT-xXeF9nYfT5-uqhBJgdnyLmiVkW8odHou9z_q3EoAKCZSE_1RAU2zIBgu8gQsFxjFXgnEzjJW2b7emuE89rYhOVB_55Z-LtIjTVeH6m3-Ltb5ldd1I-QpF5TyjPpPKZuShkBSWt2hBohbf2ZvO7v152FHlGSdHkjj3Og";
	String exp = "Sapna Shah";
	@Test
	void verifyJSONbody()
	{
		/*
		given()
			.contentType("application/json")
	        //.header("x-api-key", "iXEgGoFZnzyRO1ECjLX4c0vHpj60gF9mkcNv56LMNChucnw03RY5RNOfaN7sqEC1")  // <-- Add your custom header here
	        .header("Authorization", "Bearer" + Token) 
        
		.when()
			.get("https://graph.microsoft.com/v1.0/users/")
		
		.then()
			.statusCode(200)
			.body("value[10].displayName", equalTo("Sapna Shah"));
		*/
		
		// Approach 2
		
		Response res = given()
				.contentType("application/json")
		        //.header("x-api-key", "iXEgGoFZnzyRO1ECjLX4c0vHpj60gF9mkcNv56LMNChucnw03RY5RNOfaN7sqEC1")  // <-- Add your custom header here
		        .header("Authorization", "Bearer" + Token) 
	        
			.when()
				.get("https://graph.microsoft.com/v1.0/users/");
		
		Assert.assertEquals(res.header("Content-Type"),"application/json;odata.metadata=minimal;odata.streaming=true;IEEE754Compatible=false;charset=utf-8");
		Assert.assertEquals(res.getStatusCode(), 200);
		String str = res.jsonPath().get("value[10].displayName").toString();
		Assert.assertEquals(str, exp);
	}

}
