package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class C07_Get_BodyTekrarlardanKurtulma {
    @Test
    public void get01(){
          /*
                https://restful-booker.herokuapp.com/booking/14 url’ine
                bir GET request gonderdigimizde donen Response’un,
                status code’unun 200,
                ve content type’inin application-json,
                ve response body’sindeki
                    "firstname“in,"Josh",
                    ve "lastname“in, "Allen",
                    ve "totalprice“in, 111,
                    ve "depositpaid“in,true,
                    ve "additionalneeds“in,"midnight snack"
                oldugunu test edin

         */
        //1- Request icin gerekli url hazirlanir
        String url="https://restful-booker.herokuapp.com/booking/14";

        //2-Expected data hazirlanir
        //3-Response kaydedilir
        Response response=given().when().get(url);

        //4-Assertions
       /* response.then().assertThat().
                        statusCode(200).
                        contentType(ContentType.JSON).
                        body("firstname", Matchers.equalTo("Josh"),
                                "lastname",Matchers.equalTo("Allen"),
                                "totalprice",Matchers.equalTo(111),
                                "depositpaid",Matchers.equalTo(true),
                                "additionalneeds",Matchers.equalTo("midnight snack")
                        );*/


        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", equalTo("Josh"),
                        "lastname",equalTo("Allen"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "additionalneeds",equalTo("midnight snack")
                );








    }
}
