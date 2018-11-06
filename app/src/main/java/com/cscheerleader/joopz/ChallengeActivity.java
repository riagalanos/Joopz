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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChallengeActivity extends AppCompatActivity {

    private TextView result;
    private EditText loop_initialization, loop_bound, loop_iteration;
    private Button button_execute;
    private String url;
    private RequestQueue queue;
    private StringRequest stringRequest;
    private String loop;
    private String expected_output;
    private String init;
    private String condition_termination;
    private String increment;
    private Challenge active_problem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        active_problem = (Challenge) (getIntent().getSerializableExtra("Challenge"));
        //Log.v("FFFFFFFFFFF", active_problem.getLoop());

        loop_initialization = (EditText) findViewById(R.id.loop_initialization);
        loop_bound = (EditText) findViewById(R.id.loop_bound);
        loop_iteration = (EditText) findViewById(R.id.loop_iteration);

        int first_stop = active_problem.getLoop().indexOf("@@");
        int second_stop = active_problem.getLoop().indexOf("$$");
        int third_stop = active_problem.getLoop().indexOf("##");

        String first_part = active_problem.getLoop().substring(0, first_stop);
        String second_part = active_problem.getLoop().substring(first_stop+3, second_stop);
        //String third_part =
        //String fourth_part =

        loop_initialization.setText(first_part);
        loop_bound.setText(second_part);

        //start_value = (EditText) findViewById(R.id.start_value);
        //condition_value = (EditText) findViewById(R.id.condition_value);
        //value_change = (EditText) findViewById(R.id.value_change);
        result = (TextView) findViewById(R.id.result);
        button_execute = (Button) findViewById(R.id.button_execute);

        queue = Volley.newRequestQueue(this);
        url = "https://joopz.sites.tjhsst.edu";

        loop = active_problem.getLoop();
        expected_output = active_problem.getExpected();
        init = "";//"" + active_problem.getInitialization();
        condition_termination = ""; // "" + active_problem.getBound();
        increment = ""; //active_problem.getIteration();

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
            protected Map<String, String> getParams(){
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

