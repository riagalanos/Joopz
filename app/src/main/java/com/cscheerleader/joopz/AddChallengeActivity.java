package com.cscheerleader.joopz;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AddChallengeActivity extends AppCompatActivity {

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private DatabaseReference challengesRef;
    private ArrayList<Challenge> myChallenges;
    private Button add_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_challenge);

        add_button = (Button)findViewById(R.id.add);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        challengesRef = myRef.child("challenges");

        myChallenges = new ArrayList<Challenge>();

        /*Map<String, Challenge> challenges = new HashMap<String, Challenge>();
        challenges.put("1", new Challenge("for", "test", "5 6 7 8 9 10", 5, 10, "i++"));
        challenges.put("2", new Challenge("for", "test", "4 6 8", 4, 8, "i+=2"));*/

        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Challenge newChallenge = new Challenge("for", "test", "2 4 6", 4, 8, "i+=1");
                //Map<String, Challenge> challenges = new HashMap<String, Challenge>();
                //challenges.put("1", new Challenge("for", "test", "5 6 7 8 9 10", 5, 10, "i++"));
                //challenges.put("2", new Challenge("for", "test", "4 6 8", 4, 8, "i+=2"));
                challengesRef.child("4").setValue(newChallenge); // need to figure out how to know what num is next
            }
        });

        challengesRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                myChallenges.add(dataSnapshot.getValue(Challenge.class));
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                myChallenges.add(dataSnapshot.getValue(Challenge.class));
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



    }
}
