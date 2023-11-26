import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;


public class Basics {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
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


