package test;

import BaseUrl.JsonPlaceHolderBaseUrl;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C18_Get_TestDataClassKullanimi extends JsonPlaceHolderBaseUrl {

    /*
  https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET
  request yolladigimizda donen response’in status kodunun 200 ve
  response body’sinin asagida verilen ile ayni oldugunu test ediniz
   Response body = Expected Body
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */

    @Test
    public void get01(){
        //url
        spec.pathParams("pp1","posts","pp2",22);

        //expected data

        TestDataJsonPlaceHolder testDataJsonPlaceHolder=new TestDataJsonPlaceHolder();
        JSONObject expectedData=testDataJsonPlaceHolder.expectedBodyOlusturJson();

        //responce kaydet
        Response response=given().spec(spec).when().get("/{pp1}/{pp2}");
        response.prettyPrint();

        //asssertion
        JsonPath responceJsonPath=response.jsonPath();
        assertEquals(testDataJsonPlaceHolder.basariliStatusKodu , response.getStatusCode());
        assertEquals(expectedData.get("userId") , responceJsonPath.get("userId"));
        assertEquals(expectedData.get("id") , responceJsonPath.get("id"));
        assertEquals(expectedData.get("title") , responceJsonPath.get("title"));
        assertEquals(expectedData.get("body") , responceJsonPath.get("body"));

    }
}
