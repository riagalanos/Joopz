package com.cscheerleader.joopz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;
import android.view.View;

import java.util.ArrayList;

public class ProblemChooserActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    private ArrayList<Challenge> sublist;
    private MyRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_problem_chooser);

        sublist = (ArrayList<Challenge>) (getIntent().getSerializableExtra("List"));
        Log.v("ZZZZZZZZZZZZZZZholycow", "" + sublist.size());

        /*Recycler View
        Challenge Number with a star
        Solve Challenge Button - blue - opens Challenge Activity
        When solved - button turns white with blue border*/

        // set up the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.problemsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRecyclerViewAdapter(this, sublist);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick (View view,int position){
        Intent i = new Intent(this, ChallengeActivity.class);
        i.putExtra("Challenge", adapter.getItem(position));
        startActivity(i);
    }
}


