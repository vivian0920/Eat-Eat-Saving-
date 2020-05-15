package com.example.eateatsaving;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Confirm_NoTarget extends AppCompatActivity {


    public void sayHello(){
        Intent is=getIntent();
        TextView sayHi=(TextView) findViewById(R.id.sayHallo);
        sayHi.setText(is.getStringExtra("userName")+"! 您好呀!");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm__no_target);
    }
}
