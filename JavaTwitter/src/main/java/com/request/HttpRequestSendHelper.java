package com.request;

import authentication.OAuthHelper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ashershnov
 * Date: 6/28/16
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestSendHelper {
    public static HttpResponse sendGetRequestAndGetResponse(String url){
        HttpResponse httpResponse = null;
        HttpGet httpGet = new HttpGet(url);
        OAuthHelper.signRequest(httpGet);
        HttpClient httpClient = new DefaultHttpClient();

        try {
            httpResponse = httpClient.execute(httpGet);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }

    public static HttpResponse sendPostRequestAndGetResponse(String url){
        HttpResponse httpResponse = null;
        HttpPost httpPost = new HttpPost(url);
        OAuthHelper.signRequest(httpPost);
        HttpClient httpClient = new DefaultHttpClient();

        try {
            httpResponse = httpClient.execute(httpPost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }
}
