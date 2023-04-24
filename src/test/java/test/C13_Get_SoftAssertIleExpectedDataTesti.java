package test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C13_Get_SoftAssertIleExpectedDataTesti {
    @Test
    public void get01(){
        /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
    gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.
        Response Body--------expected data
        {
        "status":"success",
        "data":{
                "id":3,
                "employee_name":"Ashton Cox",
                "employee_salary":86000,
                "employee_age":66,
                "profile_image":""
                },
        "message":"Successfully! Record has been fetched."
        }
     */
        //1-url hazirla
        String url="http://dummy.restapiexample.com/api/v1/employee/3";

        //2-expected data hazirla
        JSONObject data=new JSONObject(); //once ici
        data.put("id",3);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        JSONObject expectedBody=new JSONObject(); // expected body nin disi
        expectedBody.put("status","success");
        expectedBody.put("data",data);
        expectedBody.put("message","Successfully! Record has been fetched.");

        //3-response i kaydet
        Response response=given().when().get(url);

        //4- assertions
        JsonPath responseJsonPath=response.jsonPath();
        SoftAssert softAssert=new SoftAssert();

        softAssert.assertEquals(responseJsonPath.get("status"),expectedBody.get("status"));

        softAssert.assertEquals(responseJsonPath.get("message"),expectedBody.get("message"));

        softAssert.assertEquals(responseJsonPath.
                               get("data.id"),expectedBody.getJSONObject("data").
                                                                       get("id"));
        softAssert.assertEquals(responseJsonPath.
                               get("data.employee_name"),expectedBody.getJSONObject("data").
                                                                       get("employee_name"));
        softAssert.assertEquals(responseJsonPath.
                               get("data.employee_salary"),expectedBody.getJSONObject("data").
                                                                       get("employee_salary"));
        softAssert.assertEquals(responseJsonPath.
                               get("data.employee_age"),expectedBody.getJSONObject("data").
                                                                       get("employee_age"));
        softAssert.assertEquals(responseJsonPath.
                               get("data.profile_image"),expectedBody.getJSONObject("data").
                                                                       get("profile_image"));
        softAssert.assertAll();







    }
}
