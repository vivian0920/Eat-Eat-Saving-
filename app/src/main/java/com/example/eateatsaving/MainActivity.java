package com.example.eateatsaving;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent ia=getIntent();
        int savingAmount=ia.getIntExtra("savingAmount",0);
        savingAmount=0;//inder to run the app ,assign 0 to savingAmount first.Then we will connect the SQL
        if(savingAmount==0){
            Intent start=new Intent(this,SetUserName.class);
            startActivity(start);
        }


    }
}
