import org.junit.Before;
import response.JSONResponseHelper;

/**
 * Created by Andrii on 29.06.2016.
 */
public class BaseTest {
    public String BASE_TWITTER_URI = "https://api.twitter.com/1.1/statuses/";
    JSONResponseHelper jsonResponseHelper;

    @Before
    public void preconditions(){
        jsonResponseHelper = new JSONResponseHelper();
    }
}
