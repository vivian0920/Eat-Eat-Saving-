package com.example.eateatsaving;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SetUserName extends AppCompatActivity implements DialogInterface.OnClickListener {
    public EditText userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_user_name);
        userName= (EditText) findViewById(R.id.userName);


    }

    public void gotoSetTarget(View v){//as long as the @id/next bottom is push then go to the next activity
        if(!userName.getText().toString().matches("")){//user fill in the name
            AlertDialog.Builder bbb=new AlertDialog.Builder(this); //create the conversation window
            bbb.setMessage("請問是否要開啟存錢功能?"+"\n"+"(也可以之後再開啟喔!)");
            bbb.setCancelable(false);
            bbb.setTitle(userName.getText().toString()+" !歡迎 !");
            bbb.setNeutralButton("BACK",null);
            bbb.setNegativeButton("NO!",this);
            bbb.setPositiveButton("YES!",this);
            bbb.show();
        }
        else{
            TextView hint=(TextView) findViewById(R.id.setNameHint);
            hint.setText("(記得要輸入名字喔!)");
        }


    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which==DialogInterface.BUTTON_NEGATIVE){
            Intent he=new Intent(this,Confirm_NoTarget.class);
            he.putExtra("userName",userName.getText().toString());
            he.putExtra("Goal","NoGoal");
            startActivity(he);

        }
        else if(which==DialogInterface.BUTTON_POSITIVE){
            Intent it = new Intent(this,SetTarget.class);
            it.putExtra("userName",userName.getText().toString());
            startActivity(it);
        }

    }
}
