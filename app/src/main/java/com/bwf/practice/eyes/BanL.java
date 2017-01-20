package com.bwf.practice.eyes;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.bwf.practice.R;

import java.util.Calendar;

/**
 * Created by Administrator on 2017/1/18.
 */

public class BanL extends Activity {
    private DatePicker datePicker;
    private TimePicker timePicker;
    private TextView tv;

    private int year;
    private int month;
    private int day;
    private int hour;
    private int min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_banl);
        datePicker = (DatePicker) findViewById(R.id.datePicker1);
        timePicker = (TimePicker) findViewById(R.id.timePicker1);
        timePicker.setIs24HourView(true);

        tv = (TextView) findViewById(R.id.textView1);
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                BanL.this.year = year;
                BanL.this.month = monthOfYear;
                BanL.this.day = dayOfMonth;
                showDateTime();
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                BanL.this.hour = hourOfDay;
                BanL.this.min = minute;
                showDateTime();
            }
        });
    }


    public void showDateTime() {
        tv.setText(year + "-" + zero((month + 1) + "") + "-" + zero(day + "") + " " + zero(hour + "") + ":" + zero(min + ""));
    }

    //补零
    public String zero(String num) {
        if (num.length() < 2) {
            return "0" + num;
        } else {
            return num;
        }
    }

}
