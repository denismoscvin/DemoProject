package files;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {

    public static JsonPath getJsonPath1(String response) {
        JsonPath jsonPath1 = new JsonPath(response);
        return jsonPath1;
    }

}
