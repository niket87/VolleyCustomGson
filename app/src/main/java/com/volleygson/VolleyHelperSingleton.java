package com.volleygson;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Niket on 22-Aug-15.
 */
public class VolleyHelperSingleton {

    private static VolleyHelperSingleton volleyHelperSingletonInstance;
    private RequestQueue requestQueue;
    Context context;

    private VolleyHelperSingleton(Context context) {
        this.context = context;
        requestQueue = getRequestQueue();
    }

    public static synchronized VolleyHelperSingleton getInstance(Context context) {
        if (volleyHelperSingletonInstance == null) {
            volleyHelperSingletonInstance = new VolleyHelperSingleton(context);
        }

        return volleyHelperSingletonInstance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }

        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
