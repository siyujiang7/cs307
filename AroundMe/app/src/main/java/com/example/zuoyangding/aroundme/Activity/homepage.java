package com.example.zuoyangding.aroundme.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.zuoyangding.aroundme.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class homepage extends AppCompatActivity {

    private ImageButton addGroupButton;
    private ImageButton profileButton;
    private Button logout;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        firebaseAuth = FirebaseAuth.getInstance();
        logout = (Button) findViewById(R.id.logout_bt);
        addGroupButton = (ImageButton) findViewById(R.id.addGroupButton);
        profileButton = (ImageButton) findViewById(R.id.profileButton);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Users").child("groupIDs");
        addGroupButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(homepage.this, add_group.class);
                homepage.this.startActivity(i);
            }
        });

        profileButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i=new Intent(homepage.this, LandingActivity.class);
                homepage.this.startActivity(i);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                Intent login = new Intent(homepage.this, LoginActivity.class);
                startActivity(login);
            }
        });
    }
}
