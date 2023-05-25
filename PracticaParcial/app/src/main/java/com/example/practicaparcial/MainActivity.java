package com.example.practicaparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addUser(View v){
        startActivity(new Intent(this, AddUserActivity.class));
    }

    public void viewUsers(View v){
        startActivity(new Intent(this, ViewUsersActivity.class));
    }
}