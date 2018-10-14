package com.cscheerleader.joopz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashboardActivity extends AppCompatActivity {

    private Button button_get_problem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.cscheerleader.joopz.R.layout.activity_dashboard);

        button_get_problem = (Button)findViewById(R.id.get_problem);

        button_get_problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, ChallengeActivity.class));
            }
        });


    }
}
