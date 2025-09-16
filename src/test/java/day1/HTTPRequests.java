package day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequests {

    private static int id; // static to share across tests (only if tests run sequentially)

    @Test(priority=1)
    public void getRequest() {
        given()
            // setup if needed
        .when()
            .get("https://reqres.in/api/users?page=2")
        .then()
            .statusCode(200)
            .body("page", equalTo(2))
            .log().all();
    }

    @Test(priority=2)
    public void createUser() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("name", "Aditya");
        data.put("job", "Train");

        String id = given()
            .contentType("application/json")
            .header("x-api-key", "reqres-free-v1")  // <-- Add your custom header here
            .body(data)
        .when()
            .post("https://reqres.in/api/users")
        .then()
            .statusCode(201)
            .log().all()
            .extract()
            .jsonPath()
            .getString("id");

        System.out.println("Created user ID: " + id);
    }
    
    @Test(priority=3, dependsOnMethods = {"createUser"})
    public void updateUser() {
        HashMap<String, Object> data1 = new HashMap<>();
        data1.put("name", "Aditya");
        data1.put("job", "Teacher");

        given()
            .contentType("application/json")
            .header("x-api-key", "reqres-free-v1")  // <-- Add your custom header here
            .body(data1)
        .when()
            .put("https://reqres.in/api/users/" + id)
        .then()
            .statusCode(200) // usually update returns 200 OK
            .log().all();
    }
    
    @Test(priority=4)
    public void deleteuser() {
    	
    	given()
        .contentType("application/json")
        .header("x-api-key", "reqres-free-v1")  // <-- Add your custom header here
        
        .when()
        .delete("https://reqres.in/api/users/" + id)
        
        .then()
        .statusCode(204) // usually update returns 200 OK
        .log().all();
    }
}