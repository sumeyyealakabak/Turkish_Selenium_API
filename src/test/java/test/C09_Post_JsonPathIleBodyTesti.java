package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C09_Post_JsonPathIleBodyTesti {
    @Test
    public void post01(){
/*
            https://restful-booker.herokuapp.com/booking
             url’ine asagidaki body'ye sahip
            bir POST request gonderdigimizde
                       {
                            "firstname" : "Ali",
                            "lastname" : "Bak",
                            "totalprice" : 500,
                            "depositpaid" : false,
                            "bookingdates" : {
                                            "checkin" : "2021-06-01",
                                            "checkout" : "2021-06-10"
                                             },
                            "additionalneeds" : "wi-fi"
                        }
            donen Response’un,
            status code’unun 200,
            ve content type’inin application-json,
            ve response body’sindeki
                "firstname“in,"Ali",
                ve "lastname“in, "Bak",
                ve "totalprice“in,500,
                ve "depositpaid“in,false,
                ve "checkin" tarihinin 2021-06-01
                ve "checkout" tarihinin 2021-06-10
                ve "additionalneeds“in,"wi-fi"
            oldugunu test edin
     */

        //1-url ve request body hazirla
        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin" , "2021-06-01").
                     put("checkout", "2021-06-10");

        JSONObject requestBody=new JSONObject();
                requestBody.put("firstname","Ali");
                requestBody.put("lastname","Bak");
                requestBody.put("totalprice",500);
                requestBody.put("depositpaid",false);
                requestBody.put("bookingdates",bookingdates);
                requestBody.put("additionalneeds","wi-fi");

                //2-Expected data hazirla


                //3- response kaydet
        Response response=given().
                                contentType(ContentType.JSON).
                           when().body(requestBody.toString()).
                                 post(url);

        //Assertions        //donen response nested json objesi ise
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                body("booking.firstname", Matchers.equalTo("Ali"),
                        "booking.lastname", Matchers.equalTo("Bak"),
                        "booking.totalprice", Matchers.equalTo(500),
                        "booking.depositpaid", Matchers.equalTo(false),
                        "booking.firstname", Matchers.equalTo("Ali"),
                        "booking.additionalneeds", Matchers.equalTo("wi-fi"),
                        "booking.bookingdates.checkin", Matchers.equalTo("2021-06-01"),
                        "booking.bookingdates.checkout", Matchers.equalTo("2021-06-10")

                    );














    }
}
