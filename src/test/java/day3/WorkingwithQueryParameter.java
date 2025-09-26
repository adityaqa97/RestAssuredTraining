package day3;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class WorkingwithQueryParameter {
	
	String Token = "eyJ0eXAiOiJKV1QiLCJub25jZSI6ImRWd1VPY2t3QVRHei1hMG43ZHdoeTV2dF9OZHFybmlyMGtkaV83YTJlZUEiLCJhbGciOiJSUzI1NiIsIng1dCI6IkpZaEFjVFBNWl9MWDZEQmxPV1E3SG4wTmVYRSIsImtpZCI6IkpZaEFjVFBNWl9MWDZEQmxPV1E3SG4wTmVYRSJ9.eyJhdWQiOiJodHRwczovL2dyYXBoLm1pY3Jvc29mdC5jb20iLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC9lYmRmMGU0Yy1lYmUyLTQ3OTMtYWY1Mi1jZWFmOTZmODI3NDEvIiwiaWF0IjoxNzU4MTg2OTIxLCJuYmYiOjE3NTgxODY5MjEsImV4cCI6MTc1ODE5MDgyMSwiYWlvIjoiazJSZ1lQaGJKaDN0bUJta1dWUEZQT0hja1IzVEFRPT0iLCJhcHBfZGlzcGxheW5hbWUiOiJNU0dyYXBoQXBwIiwiYXBwaWQiOiJmZmE2ZDllZi1iY2RkLTQ0ODktOGE5ZC04NzQ2Y2E5NjFjMWMiLCJhcHBpZGFjciI6IjEiLCJpZHAiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC9lYmRmMGU0Yy1lYmUyLTQ3OTMtYWY1Mi1jZWFmOTZmODI3NDEvIiwiaWR0eXAiOiJhcHAiLCJvaWQiOiJmZTg3YjU0Ni1iNDM0LTQ4OTYtYThkMy0wMWFlN2EzYTYzZDAiLCJyaCI6IjEuQWJFQVRBN2Y2LUxyazBldlVzNnZsdmduUVFNQUFBQUFBQUFBd0FBQUFBQUFBQUN4QUFDeEFBLiIsInJvbGVzIjpbIlVzZXIuUmVhZFdyaXRlLkFsbCIsIkFwcGxpY2F0aW9uLlJlYWRXcml0ZS5BbGwiLCJVc2VyLlJlYWQuQWxsIiwiQXBwUm9sZUFzc2lnbm1lbnQuUmVhZFdyaXRlLkFsbCJdLCJzdWIiOiJmZTg3YjU0Ni1iNDM0LTQ4OTYtYThkMy0wMWFlN2EzYTYzZDAiLCJ0ZW5hbnRfcmVnaW9uX3Njb3BlIjoiRVUiLCJ0aWQiOiJlYmRmMGU0Yy1lYmUyLTQ3OTMtYWY1Mi1jZWFmOTZmODI3NDEiLCJ1dGkiOiIteDV4MFZ3amtrQ01CTDlHd2lBTkFBIiwidmVyIjoiMS4wIiwid2lkcyI6WyIwOTk3YTFkMC0wZDFkLTRhY2ItYjQwOC1kNWNhNzMxMjFlOTAiXSwieG1zX2Z0ZCI6IlBldHFlalkyaGtvTWZqYS1pb2FGUGpqTzFzVjNudWl0b3VIVXM2U0dZTWtCWm5KaGJtTmxZeTFrYzIxeiIsInhtc19pZHJlbCI6IjcgMjYiLCJ4bXNfcmQiOiIwLjQyTGpZQkppMnNnb0pNTEJMaVNRT3lfOTJ2UF9SZzU3RXJJRXIwd1JfUWNVNVJRU3lFaDg1RmlkdThsdGMtTGJ5dXd0YWh1QW9oeENBc3dNRUhBQVNnTUEiLCJ4bXNfdGNkdCI6MTcwNjE4MzQ2MX0.VY6TwUDOaGB-y7Ytf4iH0p9FMz5qVGCSYbFO3GND3vf75JxgGmdA662FsMkMgsCAGKxco440zBwKEOhg28ZcFc-BUFaPh3T45oZW5INWDL9Ey-0i8GVJNvUUQ1-PQnjfCYNa-LwmRHKm62mDcxfBGSlaDn6eTFq3vDCeYkF2kd345EPWyQQnDC1ejN6xeyR0WwNlDE-5_SgvSx3lWxQ3__4sPMGZfw4btp-y5xvuwjulr8BBgXdeCTwv2jUisizpwxNGtLPq45eftIQ01q0ebPpxtRD52XUSY3KkpTMl7U90JIJtJpCvocXL-NEG1m2lIBOKL3g0AVcAiffFDSvEmQ";
	//@Test
	void fetchvaluefromJsonFile() throws FileNotFoundException {
		
		given()
			.contentType("application/json")
	        //.header("x-api-key", "iXEgGoFZnzyRO1ECjLX4c0vHpj60gF9mkcNv56LMNChucnw03RY5RNOfaN7sqEC1")  // <-- Add your custom header here
	        .header("Authorization", "Bearer" + Token) 
	        .pathParam("mypath", "users")
	        .queryParam("$filter", "id eq '17622d55-1edc-410a-b076-54a8a2e29e79' and displayName eq 'Samarajit Savalajakar'")
	        
		
		.when()
			.get("https://graph.microsoft.com/v1.0/{mypath}")

		.then()
			.statusCode(200)
	        .log().all();
	}

	//@Test
	void printCookiesofRequest()
	{

	Response res = given()
	
	.when()
		.get("https://login-tst.parentpaygroup.com/");
	
	
	//String cookie_ak_bmsc = res.getCookie("ak_bmsc");
	//System.out.println(cookie_ak_bmsc);
	
	Map<String, String> cookie;
	cookie = res.getCookies();
	System.out.println(cookie);
	
	

	}
	
}
