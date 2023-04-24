package test;

import BaseUrl.RestfulBookerHerokuappBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;

public class C17_BaseUrlHerokuappQueryParam extends RestfulBookerHerokuappBaseUrl {
    //Class icinde 3 Test metodu olusturun ve asagidaki testleri yapin

    /* 1- https://restful-booker.herokuapp.com/booking endpointine bir GET request
        gonderdigimizde donen response’un status code’unun 200 oldugunu ve Response’ta
        12 booking oldugunu test edin */

    /* 2- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
        parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon oldugunu test
        edecek bir GET request gonderdigimizde, donen response’un status code’unun 200
        oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin*/

    /* 3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
          parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri “Jackson”
          olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde, donen
          response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip en az bir
          booking oldugunu test edin*/
    @Test
    public void get01(){
        /* 1- https://restful-booker.herokuapp.com/booking endpointine bir GET request
        gonderdigimizde donen response’un status code’unun 200 oldugunu ve Response’ta
        12 bookingid ye sahip bir booking oldugunu test edin */
        //1- uri hazirla
        spec.pathParam("pp1","booking");

        //2-expected data hazila
        //3-Responce'i kaydet
        Response response=given().spec(spec).when().get("/{pp1}");
        response.prettyPrint();

        //4-Assertions
        response.
                then().
                assertThat().
                statusCode(200).
                body("bookingid", hasItem(12));


    }
    @Test
    public void get02(){
        /* 2- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
        parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon oldugunu test
        edecek bir GET request gonderdigimizde, donen response’un status code’unun 200
        oldugunu ve “Eric” ismine sahip en az bir booking(bookingid) oldugunu test edin*/
        //1- uri hazirla
        spec.pathParam("pp1","booking").
             queryParam("firstname","Eric");

        //2-expected data hazila
        //3-Responce'i kaydet                                 path parametresi
        Response response=given().spec(spec).when().get("/{pp1}");
        response.prettyPrint();

        //Assertion
        response.then().
                assertThat().
                statusCode(200).
                body("bookingid",hasSize(1));


    }
    @Test
    public void get03(){
         /* 3- https://restful-booker.herokuapp.com/booking endpointine gerekli Query
          parametrelerini yazarak “firstname” degeri “Jim” ve “lastname” degeri “Jackson”
          olan rezervasyon oldugunu test edecek bir GET request gonderdigimizde, donen
          response’un status code’unun 200 oldugunu ve “Jim Jackson” ismine sahip en az bir
          booking oldugunu test edin*/
        //1- uri hazirla
            spec.pathParam("pp1","booking").
                queryParams("firstname","Jim","lastname","Jackson");;

        //2-expected data hazila
        //3-Responce'i kaydet                                path param
        Response response=given().spec(spec).when().get("/{pp1}");
        response.prettyPrint();

        //4-Assertions
        response.
                then().
                assertThat().
                statusCode(200).
                body("bookingid",hasSize(3));


    }
}
