package files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DinamicJson {

    @Test(dataProvider = "BooksData")
    public void addBook(String isbn, String aisle) {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().header("Content-Type", "application/json")
                .body(payload.Addbook(isbn, aisle)).when()
                .post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

        JsonPath jsonPath = ReUsableMethods.rawToJson(response);
        String msg = jsonPath.getString("Msg");
        String id = jsonPath.get("ID");
        System.out.println("Msg: " + msg + ";  ID: " + id);
    }

//    @Test
//    public void deleteBook() {
//        RestAssured.baseURI = "http://216.10.245.166";
//        String response = given().header("Content-Type", "application/json")
//                .when().get("/Library/GetBook.php?AuthorName=John foe")
//                .then().log().all().assertThat().statusCode(200).extract().asString();
//    }

    @DataProvider(name = "BooksData")
    public Object[][] getData() {

        //array = collection of elements
        //multidimensional array = collection of arrays
        return new Object[][]{{"mybook1", "9000"}, {"mybook2", "8000"}, {"mybook3", "7000"}};
    }

}