package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_ApiSorgulama {
    /*
        https://restful-booker.herokuapp.com/booking/9856 url’ine
        bir GET request gonderdigimizde donen Response’un,
        status code’unun 200,
        ve content type’inin application/json; charset=utf-8,
        ve Server isimli Header’in degerinin Cowboy,
        ve status Line’in HTTP/1.1 200 OK
        ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.
*/

    @Test
    public  void get01(){
        // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Request Body hazirla
        // 2 - Eger soruda bize verilmisse Expected Data hazirla
        // 3 - Bize donen Response'i Actual Data olarak kaydet
        // 4 - Expected Data ile Actual Datayi karsilastirmamiz yani Assertion yapmamiz gerek

        // 1 - Gonderecegimiz Request icin gerekli olan URL ve ihtiyacimiz varsa Request Body hazirla
        String url="https://restful-booker.herokuapp.com/booking/10";

        // 2 - Eger soruda bize verilmisse Expected Data hazirla
        // 3 - Bize donen Response'i Actual Data olarak kaydet


        Response response= given().when().get(url); //reguest'i calistirir response objesine kaydeder
        response.prettyPrint();
        System.out.println("Status code: "+response.getStatusCode());
        System.out.println("Content type: "+response.getContentType());
        System.out.println("Server Header Degeri: "+response.getHeader("Server"));
        System.out.println("Status line: "+response.getStatusLine());
        System.out.println("Reponse Suresi: "+response.getTime());
    }





}
