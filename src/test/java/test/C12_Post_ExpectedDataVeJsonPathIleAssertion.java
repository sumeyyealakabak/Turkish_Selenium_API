package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C12_Post_ExpectedDataVeJsonPathIleAssertion {
    @Test
    public void post01(){
        /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
                        Request body
                   {
                        "firstname" : "Ahmet",
                        "lastname" : “Bulut",
                        "totalprice" : 500,
                        "depositpaid" : false,
                        "bookingdates" : {
                                 "checkin" : "2021-06-01",
                                 "checkout" : "2021-06-10"
                                          },
                        "additionalneeds" : "wi-fi"
                    }
                        Response Body-----expected body
                   {
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ahmet",
                        "lastname":"Bulut",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                             }
                    }
         */
        //1-url ve request body
        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");

        JSONObject requestBody=new JSONObject();
        requestBody.put("firstname" , "Ahmet");
        requestBody.put("lastname" , "Bulut");
        requestBody.put("totalprice" , 500);
        requestBody.put("depositpaid" , false);
        requestBody.put("bookingdates" ,bookingdates);
        requestBody.put("additionalneeds" , "wi-fi");

        //2- expected data
        JSONObject expectedBody=new JSONObject();
        expectedBody.put("bookingid",24);
        expectedBody.put("booking",requestBody);

        //3- responce i kaydet
        Response response=given().
                             contentType(ContentType.JSON).
                          when().
                              body(requestBody.toString()).
                              post(url);
        //4 assertions
        JsonPath responceJsonPath=response.jsonPath();
        //expected data Json Objesi, actual data Json Path seklinde oldugu iicn biz de bunlara uygun yazmamiz lazim assert te

        assertEquals(expectedBody.
                             getJSONObject("booking").
                             get("firstname"),
                     responceJsonPath.
                             get("booking.firstname"));

        assertEquals(expectedBody.
                             getJSONObject("booking").
                             get("lastname"),
                     responceJsonPath.
                             get("booking.lastname"));

        assertEquals(expectedBody.
                            getJSONObject("booking").
                            get("totalprice"),
                     responceJsonPath.
                             get("booking.totalprice"));

        assertEquals(expectedBody.
                            getJSONObject("booking").
                            get("depositpaid"),
                    responceJsonPath.
                            get("booking.depositpaid"));

        assertEquals(expectedBody.
                            getJSONObject("booking").
                            getJSONObject("bookingdates").
                            get("checkin"),
                     responceJsonPath.
                             get("booking.bookingdates.checkin"));

        assertEquals(expectedBody.
                              getJSONObject("booking").
                              getJSONObject("bookingdates").
                              get("checkout"),
                     responceJsonPath.
                               get("booking.bookingdates.checkout"));

        assertEquals(expectedBody.
                              getJSONObject("booking").
                              get("additionalneeds"),
                     responceJsonPath.
                              get("booking.additionalneeds"));








    }
}
