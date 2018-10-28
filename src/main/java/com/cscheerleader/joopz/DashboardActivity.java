package com.cscheerleader.joopz;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DashboardActivity extends AppCompatActivity {

    private Button button_get_problem;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private DatabaseReference challengesRef;
    private ArrayList<Challenge> myCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.cscheerleader.joopz.R.layout.activity_dashboard);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        challengesRef = myRef.child("challenges");

        myCollection = new ArrayList<Challenge>();

        button_get_problem = (Button)findViewById(R.id.get_problem);

        Map<String, Challenge> challenges = new HashMap<String, Challenge>();
        challenges.put("1", new Challenge("test", "5 6 7 8 9 10", 5, 10, "i++"));
        challenges.put("2", new Challenge("test", "4 6 8", 4, 8, "i+=2"));

        challengesRef.setValue(challenges);

        challengesRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                myCollection.add(dataSnapshot.getValue(Challenge.class)); //not retrieving from database
                Log.v("MMMMMMMMMMMMMMM", "" + myCollection.get(0).getBound());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                myCollection.add(dataSnapshot.getValue(Challenge.class));
                Log.v("PPPPPPPPPPPPPPP", "changed is happening");
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        button_get_problem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Challenge active_problem = myCollection.get( (int)(Math.random()*2));
                Log.v("XXXXXXXXXXXX", "" + active_problem.getBound());
                Intent i = new Intent(DashboardActivity.this, ChallengeActivity.class);
                i.putExtra("Challenge", active_problem);
                startActivity(i);
            }
        });


    }
}
