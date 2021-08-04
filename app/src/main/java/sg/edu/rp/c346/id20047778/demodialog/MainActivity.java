package sg.edu.rp.c346.id20047778.demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btnDemo1, btnDemo2, btnDemo3, btnEx3, btnDemo4, btnDemo5;
    TextView tvDemo2, tvDemo3, tvEx3, tvDemo4, tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDemo1 = findViewById(R.id.btnDemo1);
        btnDemo2 = findViewById(R.id.btnDemo2);
        tvDemo2 = findViewById(R.id.textViewDemo2);
        btnDemo3 = findViewById(R.id.btnDemo3);
        tvDemo3 = findViewById(R.id.textViewDemo3);
        btnEx3 = findViewById(R.id.btnEx3);
        tvEx3 = findViewById(R.id.textViewEx3);
        btnDemo4 = findViewById(R.id.btnDemo4);
        tvDemo4 = findViewById(R.id.tvDemo4);
        btnDemo5 = findViewById(R.id.btnDemo5);
        tvDemo5 = findViewById(R.id.tvDemo5);


        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Congratulations");
                builder.setMessage("You have completed a simple Dialog Box.");
                builder.setCancelable(false);//only can cancel when tap on button
                builder.setPositiveButton("Close",null);
                //  Demo1- Simple Dialog I can develop Android App
                AlertDialog myDialog = builder.create();
                myDialog.show();
            }
        });
        // button2
        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Demo2- Simple Dialog"); // header
                builder.setMessage("Select one of the buttons"); // body

                builder.setCancelable(false);//only can cancel when tap on button

                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("Selected Negative");
                    }
                });

                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    // adding a pathway ^^
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("Selected Positive"); // transfer text after clicking posituve.
                    }
                });

                AlertDialog myDialog = builder.create();
                myDialog.show();
            }
        });


        // button 3
        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);
                //obtain UI component in input.xml layout
                //needed to be defined as "final" so that can be used in OnClick() method vv

                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(viewDialog);
                builder.setTitle("Demo 3 - Text Input Dialog");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String message = etInput.getText().toString();
                        tvDemo3.setText(message);
                    }
                });
                builder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = builder.create();
                myDialog.show();
            }
        });
        //button3
        btnEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.ex3,null);

                final EditText edit1 = viewDialog.findViewById(R.id.etNum1);
                final EditText edit2= viewDialog.findViewById(R.id.etNum2);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(viewDialog);
                builder.setTitle("Exercise 3");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String num1 = edit1.getText().toString();
                        String num2 = edit2.getText().toString();

                        // convert string to integer
                        int sum1 = Integer.parseInt(num1);
                        int sum2 = Integer.parseInt(num2);

                        tvEx3.setText("The sum is " + (sum1+sum2));
                    }
                });

                builder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = builder.create();
                myDialog.show();
            }
        });

        //button 4
        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                };

                DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener,
                        2014,11,31);
                myDateDialog.show();
            }
        });

        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                int hourOfDay = now.get(Calendar.HOUR_OF_DAY);  // Current Hour
                int minute = now.get(Calendar.MINUTE);  // Current Minute
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: "+ hourOfDay + ":" + minute);
                    }
                };


                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener,
                        20,00,false);
                myTimeDialog.show();
            }
        });
    }

}