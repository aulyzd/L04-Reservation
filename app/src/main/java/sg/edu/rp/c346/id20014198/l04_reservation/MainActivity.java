package sg.edu.rp.c346.id20014198.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    EditText grpsize;
    EditText firstname;
    EditText lastname;
    EditText mobilenum;
    CheckBox smkarea;
    Button btnconfirm;
    Button btnreset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dp = findViewById(R.id.dateReservation);
        tp = findViewById(R.id.timeReservation);
        grpsize = findViewById(R.id.editTextgrpsize);
        firstname = findViewById(R.id.editTextFirstName);
        lastname = findViewById(R.id.editTextLastName);
        smkarea = findViewById(R.id.checkBoxSmkArea);
        btnconfirm = findViewById(R.id.buttonConfirm);
        btnreset = findViewById(R.id.buttonReset);

        btnconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = "You have confirm your reservation information - ";
                if(smkarea.isChecked()) {
                    String check="You opt for smoking area";
                    message+=check;
                } else {
                    String check="You did not opt for smoking area";
                    message+=check;
                }
                String date = ""+dp.getDayOfMonth()+"/";
                date+=dp.getMonth()+"/";
                date+=dp.getYear();

                String time = ""+tp.getCurrentHour()+":";
                time+=tp.getCurrentMinute();

                String size=grpsize.getText().toString();

                String fullname=firstname+" "+lastname;

                String mobilenumber=mobilenum.getText().toString();
                message+=date+" - "+time+" - "+size+" - "+fullname+" - "+mobilenumber+" - ";

                Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();


            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2020,5,01);

                grpsize.setText("");
                firstname.setText("");
                lastname.setText("");
                mobilenum.setText("");
                smkarea.setChecked(false);

            }
        });
    }
}