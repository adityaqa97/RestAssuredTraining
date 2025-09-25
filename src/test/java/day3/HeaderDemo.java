package day3;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class HeaderDemo {
	
	//@Test
	void printcookiesvalue()
	{

	Response res = given()
	
	.when()
		.get("https://www.google.com/");
	
	
	//String cookie_ak_bmsc = res.getCookie("ak_bmsc");
	//System.out.println(cookie_ak_bmsc);
	
	Map<String, String> cookie;
	cookie = res.getCookies();
	//System.out.println(cookie);
	for(String k: cookie.keySet())
		{
			String cookie_value = res.getCookie(k);
			System.out.println(k+"  "+cookie_value);
		}
	}
	
	//@Test(priority=1)
	void getheadervalue()
	{

	given()
	
	.when()
		.get("https://www.google.com/")
	
	.then()
		.header("Content-Encoding", "gzip")
		.header("Server","gws");
	}
	
	//@Test(priority=2)
	void printheadervalue() {
		Response res1;
		res1 = given()
				
				.when()
					.get("https://www.google.com/");
		
		//String s = res1.getHeader("Content-Type");
		//System.out.println("Header value of Context-Type is ------> "+s);
	Headers head = res1.getHeaders();
	
	for(Header hd:head)
	{
		System.out.println(hd.getName()+"----->"+hd.getValue());
	}
	
	}

	
}
