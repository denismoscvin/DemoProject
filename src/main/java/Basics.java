import files.ReUsableMethods;
import files.payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics {
    public static void main(String[] args) {

        //Add Place
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(payload.Addplace())
                .when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.52 (Ubuntu)")
                .extract().response().asString();

        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        String placeId = jsonPath.getString("place_id");
        System.out.println(placeId);


        //Update Place
        String newAddress = "70 Soroca hpuse, USA";
        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"place_id\": \"" + placeId + "\",\n" +
                        "    \"address\": \"" + newAddress + "\",\n" +
                        "    \"key\": \"qaclick123\"\n" +
                        "}")
                .when().put("/maps/api/place/update/json")
                .then().assertThat().log().all().statusCode(200)
                .body("msg", equalTo("Address successfully updated"));

        //Get Place
        String getPlaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
                .when().get("maps/api/place/get/json")
                .then().assertThat().log().all().statusCode(200).extract().response().asString();

        JsonPath jsonPath1 = ReUsableMethods.rawToJson(getPlaceResponse);
        String actualAddress = jsonPath1.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(actualAddress, newAddress);
        //Cucumber, Junit, Testng
    }
}