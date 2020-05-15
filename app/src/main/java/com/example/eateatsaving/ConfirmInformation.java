package com.example.eateatsaving;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class ConfirmInformation extends AppCompatActivity {
        public TextView sayHello;
        public TextView message;
        public TextView please;
        public TextView result;
        int savingAmount=0; //declare them with 0 because if user doesn't have the goal, we can directly update the result to SQL
        int dailyCost=0;
        public String dueDay;
        public String userName;
        public String goal;
        Intent it;
        String willing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_information);
        message=(TextView) findViewById(R.id.message);

        it =getIntent();
        userName=it.getStringExtra("userName");
        goal=it.getStringExtra("Goal");
        sayHello.setText(userName+"! 您好呀!");
        if(goal.equals("NoGoal")){ //according to the user's goal, we update the @+id/message with different text
            showNoGoal();
        }
        else {
            savingAmount=Integer.parseInt(it.getStringExtra("savingAmount"));//cannot ensure that user if has the goal so we assign them in here
            dailyCost=Integer.parseInt(it.getStringExtra("dailyCost"));
            dueDay=it.getStringExtra("dueDay");
            willing=it.getStringExtra("willing");
            sayHello=(TextView) findViewById(R.id.sayHallo);
            please=(TextView) findViewById(R.id.please);
            result=(TextView) findViewById(R.id.result);

            showGoal();
       }
    }

    public  void showNoGoal(){
        //update  @+id/message with a certain text
            message.setText("看來最近沒有想要的東西呢!"+"\n"+"那就之後有需要再設定啦!");
    }

    public  void showGoal(){
        //update @+id/message with a calculated value
        //call the calculateTheDailySaving to compute the daily saving
        please.setText("請確認以下資訊:");
        message.setText("預計將在" +dueDay+"前存滿"+savingAmount+"元"+"\n"+"經過計算，扣除掉日常預存金額後");
        result.setText("每日可用的餘額為:");//call the calculateTheDailySaving()
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int calculateTheDailySaving() throws ParseException {
        //calculate the daily cost, @+id/savingAmount /(@+id/dueDay-today)
        //get the phone's date
        SimpleDateFormat aa=new SimpleDateFormat("yyyy   /   -MM   /   -dd");
        Date due=aa.parse(dueDay);
        Date day=new Date(System.currentTimeMillis());
       // int ddday=totalDay(due,day);
       // int dailyCost=savingAmount/ddday;
         return dailyCost;
    }
    public int totalDay(Date dueDay, Date today){
        Calendar fromCalendar=Calendar.getInstance();
        fromCalendar.setTime(dueDay);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(today);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        return (int) ((toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24));
    }



}

