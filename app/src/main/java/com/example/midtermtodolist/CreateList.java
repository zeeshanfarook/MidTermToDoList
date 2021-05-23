package com.example.midtermtodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class CreateList extends AppCompatActivity {

    private static final String TAG = "CreateList";
    private TextView tvDatePicker,tvTimePicker;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TimePickerDialog.OnTimeSetListener mTimeSetListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);

        //Calendar calender = Calendar.getInstance();
        //String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calender.getTime());

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        month = month+1;

        TextView tvDatePicker = findViewById(R.id.tvDatePicker);
        tvDatePicker.setText(day+"/"+month+"/"+year+" ");
        //tvDatePicker = (TextView) findViewById(R.id.tvDatePicker);


        Calendar time = Calendar.getInstance();
        int hour = time.get(Calendar.HOUR);
        int mint = time.get(Calendar.MINUTE);
        int am_pm = time.get(Calendar.AM_PM);
        String am_pm_result;
        if(am_pm == 1)
        {
            am_pm_result = "PM";
        }
        else
        {
            am_pm_result = "AM";
        }


        TextView tvTimePicker = findViewById(R.id.tvTimePicker);
        tvTimePicker.setText(hour+":"+mint+" "+am_pm_result+" ");
        tvTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar time = Calendar.getInstance();
                int hour = time.get(Calendar.HOUR);
                int mint = time.get(Calendar.MINUTE);
                int am_pm = time.get(Calendar.AM_PM);
                boolean result;

                if(am_pm == 1)
                {
                    result = true;
                }
                else
                {
                    result = false;
                }

                TimePickerDialog dialog = new TimePickerDialog(
                        CreateList.this,
                        android.R.style.Theme_DeviceDefault_NoActionBar,
                        mTimeSetListener,
                        hour,mint,result);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

            }
        });
        tvDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog =  new DatePickerDialog(
                        CreateList.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });


        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                Log.d(TAG, "onDateSet: dd/mm/yy: "+dayOfMonth+ "/" +month+"/"+year);
                String date = dayOfMonth + "/" + month + "/" + year;
                tvDatePicker.setText(date);

            }
        };
    }
}