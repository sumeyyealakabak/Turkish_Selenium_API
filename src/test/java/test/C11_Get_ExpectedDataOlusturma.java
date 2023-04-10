package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C11_Get_ExpectedDataOlusturma {
    @Test
    public void get01(){
        /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine
    bir GET request yolladigimizda donen response body’sinin
    asagida verilen ile ayni oldugunu test ediniz
   Response body :
    {
    "userId":3,
    "id":22,
    "title":"dolor sint quo a velit explicabo quia nam",
    "body":"eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita ear
    um mollitia molestiae aut atque rem suscipit\nnam impedit esse"
    }
     */

        //1-url hazirla
        String url="https://jsonplaceholder.typicode.com/posts/22";

        //2- expected data hazirla
        JSONObject expectedBody=new JSONObject();  // Json objesi
        expectedBody.put("userId",3);
                expectedBody.put("id",22);
                expectedBody.put("title","dolor sint quo a velit explicabo quia nam");
                expectedBody.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");


                //3 response i kaydet
        Response response=given().when().get(url);

        //4- assertions
        //************ not- donen responce objesinin icindeki body e ulasmak icin*********************
        // *************** bunu json path objesine donusturmemiz gerekiyor *********************

        JsonPath responceJsonPath=response.jsonPath();
        assertEquals(expectedBody.get("userId"),responceJsonPath.get("userId"));
        assertEquals(expectedBody.get("id"),responceJsonPath.get("id"));
        assertEquals(expectedBody.get("title"),responceJsonPath.get("title"));
        assertEquals(expectedBody.get("body"),responceJsonPath.get("body"));

    }
}
