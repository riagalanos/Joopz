package com.cscheerleader.joopz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ChallengeActivity extends AppCompatActivity {

    private TextView result;
    private EditText incomplete_loop, start_value, condition_operator, condition_value, value_change;
    private Button button_compile;
    private String url;
    private RequestQueue queue;
    private StringRequest stringRequest;
    private String loop;
    private String expected_output;
    private String init;
    private String condition_termination;
    private String increment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        incomplete_loop = (EditText) findViewById(R.id.incomplete_loop);
        //start_value = (EditText) findViewById(R.id.start_value);
        //condition_value = (EditText) findViewById(R.id.condition_value);
        //value_change = (EditText) findViewById(R.id.value_change);
        result = (TextView) findViewById(R.id.result);
        button_compile = (Button) findViewById(R.id.button_compile);

        queue = Volley.newRequestQueue(this);
        url = "https://joopz.sites.tjhsst.edu";

        loop = "test";
        expected_output = "5 6 7 8";
        init = "5";
        condition_termination = "12";
        increment = "i+";

        //hardcode an entry for database
        //put entry in database
        //retrieve an item
        //populate the edittext
        //have try it button pass to volley
        //back up everything

        StringRequest putRequest = new StringRequest(Request.Method.PUT, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        result.setText("Put response is: " + response.substring(0));
                    }
                }, new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        result.setText("Galanos - the error is: " + error);
                    }
        }) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("loop",loop);
                params.put("expected_output", expected_output);
                params.put("initialization", init);
                params.put("condition_bound", condition_termination);
                params.put("iteration", increment);

                return params;
            }
        };

        queue.add(putRequest);

    }
}

