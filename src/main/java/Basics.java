import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class Basics {
    public static void main(String[] args) {
//        RestAssured.baseURI = "https://crm-dev.gbl-systems.com";
//        String response = given().log().all().header("Content-Type", "application/json")
//                .body(payload.AddPlace()).when().post("api/en/account/login")
//                .then().statusCode(200).body("email", equalTo("denis.m@gbl-factory.com"))
//                .extract().response().asString();
//
//        System.out.println(response);
//        System.out.println();
//
//
//        JsonPath jsonPath = new JsonPath(response);
//        String emailUser = jsonPath.getString("email");
    }
}


