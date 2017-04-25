package authentication;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;
import org.apache.http.HttpRequest;

/**
 * Created with IntelliJ IDEA.
 * User: ashershnov
 * Date: 6/28/16
 * Time: 5:24 PM
 * To change this template use File | Settings | File Templates.
 */

public class OAuthHelper {
    static String consumerKeyStr = "B0okoixmZicFPMAancVWWTTsn";
    static String consumerSecretStr = "FjrDQ7ImuPx8xAdeRNoSLbb1x44rMkBjjxaie0g3lglcUndprR";
    static String accessTokenStr = "743343638319529986-ni5KEy6Z7LGFiJsvKtpDLOe4lvprEXn";
    static String accessTokenSecretStr = "7MLUBik5j31VGYAJcxB3ZNTmzTWPmRKLlbw8cQ5UJIq5W";

    public static void signRequest(HttpRequest httpRequest){
        OAuthConsumer oAuthConsumer = new CommonsHttpOAuthConsumer(consumerKeyStr,consumerSecretStr);
        oAuthConsumer.setTokenWithSecret(accessTokenStr, accessTokenSecretStr);
        try {
            oAuthConsumer.sign(httpRequest);
        } catch (OAuthMessageSignerException e) {
            e.printStackTrace();
        } catch (OAuthExpectationFailedException e) {
            e.printStackTrace();
        } catch (OAuthCommunicationException e) {
            e.printStackTrace();
        }
    }
}
