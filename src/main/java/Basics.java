import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class Basics {
    public static void main(String[] args) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all().header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"location\": {\n" +
                        "        \"lat\": -99.383494,\n" +
                        "        \"lng\": 99.427362\n" +
                        "    },\n" +
                        "    \"accuracy\": 50,\n" +
                        "    \"name\": \"Soroca house\",\n" +
                        "    \"phone_number\": \"(+91) 983 893 3999\",\n" +
                        "    \"address\": \"99, side layout, cohen 99\",\n" +
                        "    \"types\": [\n" +
                        "        \"shoe park\",\n" +
                        "        \"shop\"\n" +
                        "    ],\n" +
                        "    \"website\": \"http://google.com\",\n" +
                        "    \"language\": \"English-IN\"\n" +
                        "}").when().post("/maps/api/place/add/json")
                .then().assertThat()
    }
}


