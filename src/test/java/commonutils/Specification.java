package commonutils;

import enumclass.APIEndpoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Specification {

    public static RequestSpecification requestSpecBuilder;
    public static ResponseSpecification responseSpecBuilder;
    public static ResponseSpecification responseSpec;
    static APIEndpoints endpointsAPI;
    public static Response response;


    public static RequestSpecification requestSpecification() throws IOException {

        if(requestSpecBuilder==null){
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            requestSpecBuilder = new RequestSpecBuilder().setBaseUri()
        }
    }
}
