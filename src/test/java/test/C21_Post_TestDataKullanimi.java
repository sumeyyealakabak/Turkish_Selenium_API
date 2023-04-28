package test;
import BaseUrl.HerokuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataHerokuApp;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class C21_Post_TestDataKullanimi extends HerokuAppBaseUrl{
    @Test
    public void post01(){

        // 1 - Url ve request Body hazirla

        spec.pathParam("pp1","booking");

        TestDataHerokuApp testDataHerokuApp = new TestDataHerokuApp();

        JSONObject reqBody = testDataHerokuApp.reqBodyJson();

        // 2 - Expected Data hazirla

        JSONObject expBody = testDataHerokuApp.expBodyJson();

        // 3 - Response'i kaydet

        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody.toString())
                .post("/{pp1}");

        response.prettyPeek();

        // 4 - Assertion

        JsonPath resJP = response.jsonPath();

        assertEquals( testDataHerokuApp.basariliStatusCode, response.getStatusCode() );
        assertEquals( expBody.getJSONObject("booking").get("firstname") , resJP.get("booking.firstname") );
        assertEquals( expBody.getJSONObject("booking").get("lastname")  , resJP.get("booking.lastname") );
        assertEquals( expBody.getJSONObject("booking").get("totalprice")  , resJP.get("booking.totalprice") );
        assertEquals( expBody.getJSONObject("booking").get("depositpaid")  , resJP.get("booking.depositpaid") );
        assertEquals( expBody.getJSONObject("booking").get("additionalneeds")  , resJP.get("booking.additionalneeds") );
        assertEquals( expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkin")  ,
                resJP.get("booking.bookingdates.checkin") );
        assertEquals( expBody.getJSONObject("booking").getJSONObject("bookingdates").get("checkout")  ,
                resJP.get("booking.bookingdates.checkout") );

    }

}

