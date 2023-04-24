package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {



    @Test
    public void jsonObje1(){
        /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
    */
        JSONObject ilkJsonObje=new JSONObject();
        ilkJsonObje.put("title","Ahmet");
        ilkJsonObje.put("body","Merhaba");
        ilkJsonObje.put("userId",1);
        System.out.println("ilkJsonObje = " + ilkJsonObje);
    }



    @Test
    public void jsonObje2(){
        /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                 }
         */
        JSONObject innerJsonBookingdates=new JSONObject();
        innerJsonBookingdates.put("checkin","2018-01-01");
        innerJsonBookingdates.put("checkout","2019-01-01");

        JSONObject outerJson=new JSONObject();
        outerJson.put("firstname","Jim");
        outerJson.put("additionalneeds","Breakfast");
        outerJson.put("bookingdates",innerJsonBookingdates);
        outerJson.put("totalprice",111);
        outerJson.put("depositpaid",true);
        outerJson.put("lastname","Brown");

        System.out.println(outerJson);

    }








}
