package files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DinamicJson {

    @Test
    public void addBook() {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().header("Content-Type", "application/json")
                .body(payload.Addbook())
                .when()
                .post("/Library/Addbook.php")
                .then().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath jsonPath = ReUsableMethods.getJsonPath1(response);
        jsonPath.get("ID");
    }
}
