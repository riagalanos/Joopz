package com.cscheerleader.joopz;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private DatabaseReference challengesRef;
    private ArrayList<Challenge> myCollection;
    private ArrayList<Challenge> forLoops, whileLoops, nestedLoops, twoDTravs;
    private CardView forCard, whileCard, nestedCard, twoDCard;
    private int forNumSolved, whileNumSolved, nestedNumSolved, twoDNumSolved;
    private TextView forSolved;
    private Button add;
    private boolean flag;

    // how to populate database
    // how to retrieve in time

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.cscheerleader.joopz.R.layout.activity_dashboard);

        flag=false;

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        challengesRef = myRef.child("challenges");

        myCollection = new ArrayList<Challenge>();

        forCard = (CardView)findViewById(R.id.for_card);
        whileCard = (CardView)findViewById(R.id.while_card);
        nestedCard = (CardView)findViewById(R.id.nested_card);
        twoDCard = (CardView)findViewById(R.id.twoD_card);

        add = (Button)findViewById(R.id.add_button);

        forSolved = (TextView)findViewById(R.id.for_solved);

        challengesRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                myCollection.add(dataSnapshot.getValue(Challenge.class)); //not retrieving from database
                //Log.v("MMMMMMMMMMMMMMM", "" + myCollection.get(0).getBound());
                forNumSolved = createSubListAndCountSolved("for");
                forSolved.setText("" + forNumSolved + "/" + forLoops.size() + " " + forSolved.getText());
                Log.v("XXXXXXXXXXX", ""+myCollection.size());
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                myCollection.add(dataSnapshot.getValue(Challenge.class));
                Log.v("WWWWWWWWWWWWWWW", "changed is happening");
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

        //forNumSolved = createSubListAndCountSolved("for");
        //forSolved.setText("" + forNumSolved + "/" + forLoops.size() + " " + forSolved.getText());

        // DashboardActivity pulls from firebase
        // if add challenge button is pressed, AddChallengeActivity opened
        // AddChallengeActivity adds to Firebase, doesn't need to retrieve

        forCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sends the list with just for loops to ProblemChooserActivity
                Intent i = new Intent(DashboardActivity.this, ProblemChooserActivity.class);
                i.putExtra("List",forLoops);
                startActivity(i);
            }
        });

        whileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sends the list with just while loops to ProblemChooserActivity
                Intent i = new Intent(DashboardActivity.this, ProblemChooserActivity.class);
                i.putExtra("List",whileLoops);
                startActivity(i);
            }
        });

        nestedCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sends the list with just nested loops to ProblemChooserActivity
                Intent i = new Intent(DashboardActivity.this, ProblemChooserActivity.class);
                i.putExtra("List",nestedLoops);
                startActivity(i);
            }
        });

        twoDCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //sends the list with just 2D array traversals to ProblemChooserActivity
                Intent i = new Intent(DashboardActivity.this, ProblemChooserActivity.class);
                i.putExtra("List",twoDTravs);
                startActivity(i);
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DashboardActivity.this, AddChallengeActivity.class);
                startActivity(i);
            }
        });


    }

    // helper method
    public int createSubListAndCountSolved (String type) {
        Log.v("BBBBBBBBBBBBBB", ""+myCollection.size());
        int count = 0;
        if (type.equals("for")){
            forLoops = new ArrayList<Challenge>();
            for (Challenge val: myCollection) {
                if (val.getType().equals(type)) {
                    forLoops.add(val);
                    if (val.isSolved())
                        count++;
                }
            }
        }
        else if (type.equals("while")){
            whileLoops = new ArrayList<Challenge>();
            for (Challenge val : myCollection) {
                if (val.getType().equals(type)) {
                    whileLoops.add(val);
                    if (val.isSolved())
                        count++;
                }
            }
        }
        else if (type.equals("nested")){
            nestedLoops = new ArrayList<Challenge>();
            for (Challenge val : myCollection) {
                if (val.getType().equals(type)) {
                    nestedLoops.add(val);
                    if (val.isSolved())
                        count++;
                }
            }
        }
        else if (type.equals("twoD")){
            twoDTravs = new ArrayList<Challenge>();
            for (Challenge val : myCollection) {
                if (val.getType().equals(type)) {
                    twoDTravs.add(val);
                    if (val.isSolved())
                        count++;
                }
            }
        }
        return count;
    }
}
