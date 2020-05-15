package com.example.eateatsaving;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class SetTarget extends AppCompatActivity implements View.OnClickListener , DatePickerDialog.OnDateSetListener {
        Calendar c =Calendar.getInstance();//contribute the calendar object
        public TextView txDate;
        public EditText target;
        public EditText savingAmount;
        public EditText dailyCost;
        public TextView dueday;
        public TextView hint;
        public TextView dueDay;
        public CheckBox willing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_target);
        sayHello();
        txDate=(TextView)findViewById(R.id.dueDate);
        txDate.setOnClickListener(this);
        target=(EditText)findViewById(R.id.Target);
        savingAmount=(EditText)findViewById(R.id.SavingAmount);
        dailyCost=(EditText)findViewById(R.id.DailyCost);
        dueday=(TextView) findViewById(R.id.dueDate);
        hint=(TextView) findViewById(R.id.Hint);
        dueDay=(TextView) findViewById(R.id.dueDate);
        willing=(CheckBox)findViewById(R.id.checkBox);
    }

    public void sayHello(){
        Intent is=getIntent();
        TextView sayHi=(TextView) findViewById(R.id.sayHallo);
        sayHi.setText(is.getStringExtra("userName")+"! 您好呀!");
    }
    public void gobacktoSetUserName(View v){
        finish();
    }
    public void gotoConfirmInformation(View v){//go to the next activity
        if(!target.getText().toString().matches(" ")||!savingAmount.getText().toString().matches(" ")||!dailyCost.getText().toString().matches(" ")||dueday.getText().toString().matches("____ / ____  / ____ "))
        {
        Intent it = new Intent(this,ConfirmInformation.class);
        it.putExtra("Goal",target.getText().toString());
        it.putExtra("savingAmount",savingAmount.getText().toString());
        it.putExtra("dailyCost",dailyCost.getText().toString());
        it.putExtra("dueDay",dueday.getText().toString());
        if (willing.isChecked()){it.putExtra("willing","YES");}
        startActivity(it);
        }
        else {
            hint.setText("全部都要記得輸入喔!");//if user don't fill up all editText
        }
    }

    @Override
    public void onClick(View v) {
        new DatePickerDialog(this,this,c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DATE)).show();

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        int realmonth=month+1;
        dueDay.setText(year+"   /   "+realmonth+"   /   "+dayOfMonth);

    }
}
