import com.request.HttpRequestResponseHelper;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import utils.HttpRequestTypes;

/**
 * Created with IntelliJ IDEA.
 * User: ashershnov
 * Date: 6/28/16
 * Time: 6:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class UserTimelineTest extends BaseTest{
    private String USER_TIMLINE = "user_timeline.json";
    static Logger log = Logger.getLogger(UserTimelineTest.class.getName());
    private final int STATUS_CODE_OK = 200;

    @Test
    @Category(UserTimelineTest.class)
    public void checkResponseForExistingUserIdTest() throws Exception {
        log.info("Started: checkResponseForExistingUserIdTest");
        HttpResponse httpResponse = HttpRequestResponseHelper.
                sendRequest(BASE_TWITTER_URI + USER_TIMLINE + "?user_id=743343638319529986", HttpRequestTypes.GET);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        Assert.assertTrue(statusCode == STATUS_CODE_OK);
        jsonResponseHelper.parseJSON(IOUtils.toString(httpResponse.getEntity().getContent()));
        Assert.assertTrue(jsonResponseHelper.getFirstElementValByName("user", "id").equals("743343638319529986"));
    }

    @Test
    @Category(UserTimelineTest.class)
    public void checkResponseForNotExistingUserIdTest() throws Exception {
        log.info("Started: checkResponseForNotExistingUserIdTest");
        HttpResponse httpResponse = HttpRequestResponseHelper.
                sendRequest(BASE_TWITTER_URI  + USER_TIMLINE +  "?user_id=746980524539920384", HttpRequestTypes.GET);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        Assert.assertTrue(statusCode != STATUS_CODE_OK);
        String resp = IOUtils.toString(httpResponse.getEntity().getContent()).substring(10, 68);
        jsonResponseHelper.parseJSON(resp);
        Assert.assertTrue(jsonResponseHelper.getFirstElementValByName("message").equals("Sorry, that page does not exist."));
    }


    @Test
    @Category(UserTimelineTest.class)
    public void checkIdAndScreenNameForExistingUserIAndExistingScreenNameTest() throws Exception {
        HttpResponse httpResponse = HttpRequestResponseHelper.
                sendRequest(BASE_TWITTER_URI + USER_TIMLINE + "?screen_name=sadmikalai&user_id=743343638319529986", HttpRequestTypes.GET);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        Assert.assertTrue(statusCode == STATUS_CODE_OK);

        jsonResponseHelper.parseJSON(IOUtils.toString(httpResponse.getEntity().getContent()));
        Assert.assertTrue(jsonResponseHelper.getFirstElementValByName("user", "id").equals("3301902172"));
        Assert.assertTrue(jsonResponseHelper.getFirstElementValByName("user", "screen_name").equals("sadmikalai"));
    }

    @Test
    @Category(UserTimelineTest.class)
    public void checkIdAndScreenNameForNotExistingUserIAndExistingScreenNameTest() throws Exception {
        HttpResponse httpResponse = HttpRequestResponseHelper.
                sendRequest(BASE_TWITTER_URI + USER_TIMLINE + "?screen_name=kinopoiskru3&user_id=746980524539920384",
                        HttpRequestTypes.GET);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        log.info(statusCode);
        log.info(IOUtils.toString(httpResponse.getEntity().getContent()));
        Assert.assertTrue(statusCode != STATUS_CODE_OK);
    }


    @Test
    @Category(UserTimelineTest.class)
    public void checkCountTest() throws Exception {
        for(int i = 1; i < 7; i++) {
            HttpResponse httpResponse = HttpRequestResponseHelper.
                    sendRequest(BASE_TWITTER_URI + USER_TIMLINE + "?screen_name=sadmikalai&count=" + i,
                            HttpRequestTypes.GET);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            Assert.assertTrue(statusCode == STATUS_CODE_OK);
            jsonResponseHelper.parseJSON(IOUtils.toString(httpResponse.getEntity().getContent()));
            Assert.assertTrue(jsonResponseHelper.getCountOfResponseRows() == i);
        }
    }

    @Test
    @Category(UserTimelineTest.class)
    public void checkCountWithZeroCountTest() throws Exception {
            HttpResponse httpResponse = HttpRequestResponseHelper.
                    sendRequest(BASE_TWITTER_URI + USER_TIMLINE + "?screen_name=sadmikalai&count=0",
                            HttpRequestTypes.GET);
            int statusCode = httpResponse.getStatusLine().getStatusCode();
            Assert.assertTrue(statusCode == STATUS_CODE_OK);
            jsonResponseHelper.parseJSON(IOUtils.toString(httpResponse.getEntity().getContent()));
            Assert.assertTrue(jsonResponseHelper.getCountOfResponseRows() == 20);
    }

}
