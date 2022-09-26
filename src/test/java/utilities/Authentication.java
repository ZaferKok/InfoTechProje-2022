package utilities;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Authentication {

    public static String tokenGenerate(){

        String url = "https://medunna.com/api/authenticate";

        Map<String, String> expectedData = new HashMap();
        expectedData.put("username","infoTech02");
        expectedData.put("password","Admin123.");

        Response response = given().contentType(ContentType.JSON).body(expectedData).when().post(url);

        return response.path("id_token");
    }

    public static void main(String[] args) {
        System.out.println(tokenGenerate());
    }
}
