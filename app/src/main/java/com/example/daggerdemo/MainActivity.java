package com.example.daggerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    RegistrationManager registrationManager;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button signButton;
    private Button loginButton;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUsername = findViewById(R.id.editTextText);
        editTextPassword = findViewById(R.id.editTextText2);
        signButton = findViewById(R.id.button);
        loginButton = findViewById(R.id.button2);

        DaggerRegistrationComponent.builder()
                .module(new Module("",""))
                .build()
                .inject(this);

        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                user = registrationManager.registerUser(username, password);
                Toast.makeText(MainActivity.this, "已註冊", Toast.LENGTH_SHORT).show();
                editTextUsername.setText("");
                editTextPassword.setText("");
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputPassword = editTextPassword.getText().toString();
                String inputUsername = editTextUsername.getText().toString();
                if (inputPassword.equals(user.getPassword()) && inputUsername.equals(user.getUsername())) {
                    Toast.makeText(MainActivity.this, "登入成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "無效的帳號密碼", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}