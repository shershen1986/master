import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import org.testng.annotations.Test;
import pojo.ChackJoke;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsNull.notNullValue;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.logging.Logger;

public class RestApiTest {
    private final static Logger log = Logger.getLogger(RestApiTest.class.getName());


    @Test
    public void extractingIntoObjJsonResponseUsingJacksonTest(){
        ObjectMapper mapper = new ObjectMapper();
        Response response = given().relaxedHTTPSValidation()
                .header("x-rapidapi-key","SIGN-UP-FOR-KEY")
                .header("useQueryString","true")
                .get("https://api.chucknorris.io/jokes/random");

        try {
            createJsonAttachment("response",
                    response.getHeaders().toString(),
                    response.asPrettyString());
            /**
            *Making assertion
            * */

            response.
                    then().
                    assertThat().statusCode(200)
                    .assertThat().body("value", notNullValue());

            /**
             * Injecting response into the ChackJoke object
             * */
            ChackJoke chackJoke = mapper.readValue(response.getBody().asString(), ChackJoke.class);
            log.info(chackJoke.toString());
            log.info(chackJoke.getValue());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void extractingIntoObjJsonResponseUsingRestAssuredTest(){
        FilterableRequestSpecification request = (FilterableRequestSpecification) given().relaxedHTTPSValidation()
                .header("x-rapidapi-key","SIGN-UP-FOR-KEY")
                .header("useQueryString","true");

        Response response = request.get("https://api.chucknorris.io/jokes/random");

        createJsonAttachment("request",
                request.getURI() +
                        "\r\nMethod: " + request.getMethod() + "\r\n" + request.getHeaders().toString(),
                request.getBody());

        createJsonAttachment("response",
                response.getHeaders().toString(),
                response.asPrettyString());
        /**
        * Injecting response into the ChackJoke object
        * Making assertions
        * */
        ChackJoke chackJoke = response.then()
                .assertThat().statusCode(200)
                .assertThat().body("value", notNullValue())
                .extract().body()
                .as(ChackJoke.class);

        log.info(chackJoke.toString());
    }


/**
 * Creating attachments in allure report
 * */

    @Attachment(value = "{0}",type = "text/json")
    public static String createJsonAttachment(String attachName, String headers, String message) {
        return headers + "\r\n\r\n\n" + message;
    }

    @Attachment(value = "{0}",type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Attachment(value = "{0}",type = "text/xml")
    public static String createXmlAttachment(String attachName, String message) {
        return message;
    }
}
