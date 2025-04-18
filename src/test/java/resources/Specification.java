package resources;

import resources.APIEndpoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.ConfigReader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Specification {

    public static RequestSpecification requestSpecBuilder;
    public static ResponseSpecification responseSpecBuilder;
    static APIEndpoints endpointsAPI;
    public static Response response;


    public static RequestSpecification requestSpecification() throws IOException {

        if(requestSpecBuilder==null){
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            requestSpecBuilder =  new RequestSpecBuilder().setBaseUri(ConfigReader.getGlobalValue("baseURI"))
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .build();
            return requestSpecBuilder;
        }
        return requestSpecBuilder;
    }

    public static String resource(String resource) {
        endpointsAPI = APIEndpoints.valueOf(resource);
        String apiEndpoint = endpointsAPI.getResource();
        return apiEndpoint;
    }

    public static String getJsonPath(Response response, String key) {
        String resp=response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();
    }

    public static ResponseSpecification responseSpecification(Integer statusCode) {
        System.out.println("In responseSpecification");

        Map<String, Object> expectedHeaders = new HashMap<>();
        expectedHeaders.put("Server","Cowboy");
        expectedHeaders.put("Connection", "keep-alive");
        expectedHeaders.put("Via", "1.1 vegur");

        responseSpecBuilder = new ResponseSpecBuilder().expectStatusCode(statusCode)
                .expectHeaders(expectedHeaders)
                .build();

        return responseSpecBuilder;
    }


}
