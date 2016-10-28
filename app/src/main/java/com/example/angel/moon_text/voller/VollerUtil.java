package com.example.angel.moon_text.voller;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by Angel on 2016/10/28.
 */

public class VollerUtil {
    RequestQueue mRequestQueue;
    public void getStingResult() {
        String url = "http://118.244.212.82:9092/newsClient/news_list?ver=1&subid=1&dir=3&nid=1&stamp=20140321&cnt=20";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(final String s) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });

        mRequestQueue.add(request);
    }
}
