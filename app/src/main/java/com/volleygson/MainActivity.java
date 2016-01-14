package com.volleygson;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {

    TextView tvResponse;
    Button btnRequest;

    RequestQueue requestQueue;
    StringRequest stringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResponse = (TextView) findViewById(R.id.txt_response);
        btnRequest = (Button) findViewById(R.id.btn_send_request);

        //requestQueue = Volley.newRequestQueue(this);

        /*String url = "http://icetea09.com";
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

            @Override
            public void onResponse(String res) {
                tvResponse.setText(res);
            }

        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError err) {
                tvResponse.setText(err.getMessage());
            }
        });

        btnRequest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                requestQueue.add(stringRequest);
            }
        });
    }*/

        String url = "http://api.androidhive.info/contacts/";

        final GsonRequest gsonRequest = new GsonRequest(url, AllContacts.class, null, new Response.Listener<AllContacts>() {

            @Override
            public void onResponse(AllContacts allContacts) {
                String textResult = "";
                List<Contact> contactList = new ArrayList<Contact>();
                contactList = allContacts.getContacts();
                for(int i=0; i<contactList.size(); i++){
                    Contact contact = contactList.get(i);
                    textResult += "ID: " + contact.getName() + "\n";
                    textResult += "Name: " + contact.getName() + "\n";
                    textResult += "Email: " + contact.getEmail() + "\n";
                    textResult += "Address: " + contact.getAddress() + "\n";
                    textResult += "Gender: " + contact.getGender() + "\n";
                    textResult += "Phone-Mobile: " + contact.getPhone().getMobile() + "\n";
                    textResult += "Phone-Home: " + contact.getPhone().getOffice() + "\n";
                    textResult += "Phone-Office: " + contact.getPhone().getOffice() + "\n\n";
                }
                tvResponse.setText(textResult);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if(volleyError != null) Log.e("MainActivity", volleyError.getMessage());
            }
        });

        btnRequest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                (VolleyHelperSingleton.getInstance(getApplicationContext())).getRequestQueue().add(gsonRequest);
            }
        });

    }
}