package BaseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyBaseUrl {
    //https://dummy.restapiexample.com
    protected RequestSpecification spec;
    @Before
    public void setUp(){
        spec=new RequestSpecBuilder().
                setBaseUri("https://dummy.restapiexample.com").
                build();
}}
