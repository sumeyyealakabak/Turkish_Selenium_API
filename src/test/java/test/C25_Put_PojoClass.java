package test;

import BaseUrl.JsonPlaceHolderBaseUrl;
import Pojos.JsonPlaceHolderRequestBodyPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_PojoClass extends JsonPlaceHolderBaseUrl {

     /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
 body’e sahip bir PUT request yolladigimizda donen response’in
 response body’sinin asagida verilen ile ayni oldugunu test ediniz
     Request Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
    Expected Body
    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */

    @Test
    public void put01() {

        // 1 - Url ve Body hazirla

        spec.pathParams("pp1","posts","pp2",70);

        JsonPlaceHolderRequestBodyPojo reqBody = new JsonPlaceHolderRequestBodyPojo("Ahmet","Merhaba",10,70);

        System.out.println("reqBody = " + reqBody);

        // 2 - Expected Data hazirla

        JsonPlaceHolderRequestBodyPojo expBody = new JsonPlaceHolderRequestBodyPojo("Ahmet","Merhaba",10,70);

        // 3 - Response'i kaydet

        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .when()
                .body(reqBody)
                .put("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4 - Assertion

        //  JsonPath resJP = response.jsonPath();
        //  Map<String, Object> resMap = response.as(HashMap.class);

        JsonPlaceHolderRequestBodyPojo resPojo = response.as(JsonPlaceHolderRequestBodyPojo.class);

        assertEquals( expBody.getTitle() , resPojo.getTitle() );
        assertEquals( expBody.getBody()  , resPojo.getBody() );
        assertEquals( expBody.getId()    , resPojo.getId() );
        assertEquals( expBody.getUserId(), resPojo.getUserId() );
    }
}


