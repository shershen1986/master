import com.request.HttpRequestResponseHelper;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.Suite;
import utils.HttpRequestTypes;

/**
 * Created by ashershnov on 7/1/2016.
 */
public class UpdateTest extends BaseTest {
    private String UPDATE_URI_PREFIX = "update.json";
    private final int STATUS_CODE_OK = 200;
    static Logger log = Logger.getLogger(UpdateTest.class.getName());

    @Test
    @Ignore
    @Category(UpdateTest.class)
    public void checkStatusCommandForUniqLessThen140SymbolsMessageTest() throws Exception {
        log.info("Started: checkStatusCommandForUniqLessThen140SymbolsMessageTest");
        HttpResponse httpResponse = HttpRequestResponseHelper.
                sendRequest(BASE_TWITTER_URI + UPDATE_URI_PREFIX + "?status=Maybe%20he%27ll%20finally%20find%20his%20keys.%20%23Lion", HttpRequestTypes.POST);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        Assert.assertTrue(statusCode == STATUS_CODE_OK);
        String responseText = IOUtils.toString(httpResponse.getEntity().getContent());
        log.info(statusCode + " : " + responseText);
        Assert.assertTrue(responseText.contains("Maybe he'll finally find his keys. #Lion"));
    }

    @Test
    @Category(UpdateTest.class)
    public void checkStatusCommandForUniqGreaterThen140SymbolsMessageTest() throws Exception {
        log.info("Started: checkStatusCommandForUniqGreaterThen140SymbolsMessageTests");
        HttpResponse httpResponse = HttpRequestResponseHelper.
                sendRequest(BASE_TWITTER_URI + UPDATE_URI_PREFIX + "?status=Maybe%20he%27ll%20finally%20find%20his%20keys.%20%23LionMaybe%20he%27ll%20finally%20find%20his%20keys.%20%23LionMaybe%20he%27ll%20finally%20find%20hisMaybe%20he%27ll%20finally%20find%20hisytrtyryyrty",
                        HttpRequestTypes.POST);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        Assert.assertTrue(statusCode == 403);
        log.info(statusCode);
        jsonResponseHelper.parseJSON(IOUtils.toString(httpResponse.getEntity().getContent()));
        Assert.assertTrue(jsonResponseHelper.getFirstElementValByName("errors", "message").equals("Status is over 140 characters."));
    }

}
