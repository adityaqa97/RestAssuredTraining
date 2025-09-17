package day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class DifferentWaystoPOSTRequest {

	//@Test
	void fetchvaluefromHashMap() {
		HashMap<String,Object> data = new HashMap<>();
		data.put("emailAddress","aditya.sharma@parentpay.com");
		data.put("productIdentity", "schoolcomms");
		data.put("providerType", "federated");
		data.put("JourneyType", "InvitationConfirmation");
		data.put("UserPersona", "IAUser");
		data.put("OtpGenerated", "343806");
		data.put("changedEmailAddress", "aditya.sharma@pptestsite.com");
		
		given()
			.contentType("application/json")
	        .header("x-api-key", "iXEgGoFZnzyRO1ECjLX4c0vHpj60gF9mkcNv56LMNChucnw03RY5RNOfaN7sqEC1")  // <-- Add your custom header here
	        .body(data)
		
		.when()
			.post("https://api.tst-auth-services.parentpay.com/api/v1/EmailVerification/SendConfirmationEmail")

		.then()
			.statusCode(200)
	        .log().all();
	}
	
	//@Test
	void fetchvaluefromJSONOrg() {
		JSONObject data1 = new JSONObject();
		data1.put("emailAddress","aditya.sharma@parentpay.com");
		data1.put("productIdentity", "schoolcomms");
		data1.put("providerType", "federated");
		data1.put("JourneyType", "InvitationConfirmation");
		data1.put("UserPersona", "IAUser");
		data1.put("OtpGenerated", "343806");
		data1.put("changedEmailAddress", "aditya.sharma@pptestsite.com");
		
		given()
			.contentType("application/json")
	        .header("x-api-key", "iXEgGoFZnzyRO1ECjLX4c0vHpj60gF9mkcNv56LMNChucnw03RY5RNOfaN7sqEC1")  // <-- Add your custom header here
	        .body(data1.toString())
		
		.when()
			.post("https://api.tst-auth-services.parentpay.com/api/v1/EmailVerification/SendConfirmationEmail")

		.then()
			.statusCode(200)
	        .log().all();
	}
	
	//@Test
	void fetchvaluefromPOJOClass() {
		
		Pojo_data data2 = new Pojo_data();
		data2.setEmailAddress("aditya.sharma@parentpay.com");
		data2.setProductIdentity("schoolcomms");
		data2.setProviderType("federated");
		data2.setJourneyType("InvitationConfirmation");
		data2.setUserPersona("IAUser");
		data2.setOtpGenerated("343806");
		data2.setChangedEmailAddress("aditya.sharma@pptestsite.com");
		
		given()
			.contentType("application/json")
	        .header("x-api-key", "iXEgGoFZnzyRO1ECjLX4c0vHpj60gF9mkcNv56LMNChucnw03RY5RNOfaN7sqEC1")  // <-- Add your custom header here
	        .body(data2)
		
		.when()
			.post("https://api.tst-auth-services.parentpay.com/api/v1/EmailVerification/SendConfirmationEmail")

		.then()
			.statusCode(200)
	        .log().all();
	}
	
	//@Test
	void fetchvaluefromJsonFile() throws FileNotFoundException {
		
		File f = new File(".\\body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data3 = new JSONObject(jt);
		System.out.println(data3.toString());
		given()
			.contentType("application/json")
	        .header("x-api-key", "iXEgGoFZnzyRO1ECjLX4c0vHpj60gF9mkcNv56LMNChucnw03RY5RNOfaN7sqEC1")  // <-- Add your custom header here
	        .body(data3.toString())
	        
		
		.when()
			.post("https://api.tst-auth-services.parentpay.com/api/v1/SMSVerification/SendSMSOTP")

		.then()
			.statusCode(200)
	        .log().all();
	}
}
