package testData;

import org.json.JSONObject;

public class TestDataDummy {

    public JSONObject requestBodyOlusturDummy(){
        /*
        Request Body
       {
           "status": "success",
           "data": {
                   "name": “Ahmet",
                   "salary": "1230",
                   "age": "44",
                   "id": 40
            }
        }
         */
        JSONObject requestBody=new JSONObject();

        requestBody.put("status","success");
        requestBody.put("data",data());


        return requestBody;

    }
    public JSONObject data(){

        JSONObject data=new JSONObject();
        data.put("name","Ahmet");
        data.put("salary",1230);
        data.put("age",44);
        data.put("id",40);

        return data;
    }


}
