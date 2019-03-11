package com.example.ccetsports;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user_name, user_pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_name = (EditText) findViewById(R.id.user_name);
        user_pass = (EditText) findViewById(R.id.user_pass);

        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLogin();
            }
        });
    }

    public void onLogin(){
        String userName = user_name.getText().toString().trim();
        String userPass = user_pass.getText().toString().trim();
        String type = "login";
        if(userName.isEmpty() || userPass.isEmpty()){
            Toast.makeText(getApplicationContext(), "Fill all text boxes", Toast.LENGTH_LONG).show();
        }
        else {
            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            backgroundWorker.execute(type, userName, userPass);
        }
    }

}
