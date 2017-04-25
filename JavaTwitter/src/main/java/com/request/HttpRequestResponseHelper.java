package com.request;

import authentication.OAuthHelper;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import utils.HttpRequestTypes;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: ashershnov
 * Date: 6/28/16
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class HttpRequestResponseHelper {
    public static HttpResponse sendRequest(String url, HttpRequestTypes method) throws Exception {
        HttpResponse httpResponse = null;
        HttpRequest request;
        if(method == HttpRequestTypes.GET){
            request = new HttpGet(url);
        }else if(method == HttpRequestTypes.POST){
            request = new HttpPost(url);
        }else{
            throw new Exception();
        }

        OAuthHelper.signRequest(request);
        HttpClient httpClient = new DefaultHttpClient();
        try {

            httpResponse = httpClient.execute((HttpUriRequest)request);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return httpResponse;

    }
}
