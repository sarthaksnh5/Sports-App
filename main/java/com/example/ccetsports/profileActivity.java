package com.example.ccetsports;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class profileActivity extends AppCompatActivity {

    TextView personName, personRoll, personBranch, personYear;
    Spinner games;
    Button sendData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        personName = findViewById(R.id.usr_name);
        personRoll = findViewById(R.id.usr_roll);
        personYear = findViewById(R.id.usr_year);
        personBranch = findViewById(R.id.usr_branch);

        games = findViewById(R.id.games);

        sendData = (Button) findViewById(R.id.sendData);

        Intent dataIntent = getIntent();
        personName.setText(dataIntent.getStringExtra("Name"));
        personRoll.setText(dataIntent.getStringExtra("Roll"));
        personYear.setText(dataIntent.getStringExtra("Year"));
        personBranch.setText(dataIntent.getStringExtra("Branch"));

        sendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usrName = personName.getText().toString().trim();
                String usrBranch = personBranch.getText().toString().trim();
                String usrYear = personYear.getText().toString().trim();
                String usrRoll = personRoll.getText().toString().trim();
                String usrGame = games.getSelectedItem().toString().trim();
                String type = "register";
                if(usrBranch.isEmpty() || usrGame.isEmpty() || usrName.isEmpty() || usrRoll.isEmpty() || usrYear.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Fill up all your details", Toast.LENGTH_LONG).show();
                }
                else{
                    BackgroundWorker backgroundWorker = new BackgroundWorker(getApplicationContext());
                    backgroundWorker.execute(type, usrName, usrRoll, usrYear, usrBranch, usrGame);
                }
            }
        });

    }
}
