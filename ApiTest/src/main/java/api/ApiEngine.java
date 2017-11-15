package api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.yandex.qatools.allure.annotations.Attachment;

import static io.restassured.RestAssured.given;

/**
 * Created by osolomin on 15.11.17.
 */
public class ApiEngine {

    private static ThreadLocal<RequestSpecification> requestSpecification = new ThreadLocal<RequestSpecification>();

    public static RequestSpecification getRequestSpecification(){
        if(requestSpecification.get() == null){
            requestSpecification.set(new RequestSpecBuilder()
                    .addHeader("Accept", "application/json, text/javascript")
                    .setBaseUri(Endpoints.BASE_URL)
                    .log(LogDetail.ALL)
                    .build());
        }
        return requestSpecification.get();
    }

    public static void removeRequestSpecification(){
        requestSpecification.set(null);
    }

    @Attachment
    public String doGet(String endpoint){
        return given(getRequestSpecification()).get(endpoint).asString();
    }

    @Attachment
    public Response doPost(String endpoint, Object body){
        return given(getRequestSpecification()).post(endpoint, body);
    }
}
