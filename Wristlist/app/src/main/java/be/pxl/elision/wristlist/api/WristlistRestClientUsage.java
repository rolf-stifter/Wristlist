package be.pxl.elision.wristlist.api;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by 11308157 on 16/12/2016.
 */

public class WristlistRestClientUsage {

    private static final String BASE_URL = "http://10.0.2.2:8080/";

    private static AsyncHttpClient client = new AsyncHttpClient();


    public static void post(Context context, String url, StringEntity params, AsyncHttpResponseHandler responseHandler) {
        client.post(context, getAbsoluteUrl(url), params, "application/json", responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }

}
