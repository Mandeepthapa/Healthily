package com.example.ejesh.health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;

public class SignUp extends AppCompatActivity {

   // DatabaseHelper myDb;
    Button Btn;
    EditText editname, editage;
    RadioGroup radioGender, radioTime;
    RadioButton rb1, rb2;
    RadioGroup rgGender;
    CheckBox cb,cb1,cb2,cb3,cb4,cb5,cb6;
    AwesomeValidation awesomeValidation;

    HealthilyPreference healthilyPreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main2);
        //myDb = new DatabaseHelper (this);
        healthilyPreference = new HealthilyPreference (this);
        editname=(EditText)findViewById (R.id.nameEditText);
        editage=(EditText)findViewById (R.id.ageEditText);

        radioGender = (RadioGroup) findViewById (R.id.radioGroup2);

        radioTime = (RadioGroup) findViewById (R.id.radioGroup);
        Btn = (Button) findViewById (R.id.nxtBtn);
        cb=(CheckBox)findViewById (R.id.checkBox);
        cb1=(CheckBox)findViewById (R.id.checkBox1);
        cb2=(CheckBox)findViewById (R.id.checkBox2);
        cb3=(CheckBox)findViewById (R.id.checkBox3);
        cb4=(CheckBox)findViewById (R.id.checkBox4);
        cb5=(CheckBox)findViewById (R.id.checkBox5);
        cb6=(CheckBox)findViewById (R.id.checkBox6);
        awesomeValidation= new AwesomeValidation (ValidationStyle.BASIC);
        updateUI();
        AddData ( );
    }

    private void updateUI() {

        awesomeValidation.addValidation (SignUp.this,R.id.nameEditText,"[a-zA-Z\\s]+",R.string.nameerr);

        awesomeValidation.addValidation (SignUp.this,R.id.ageEditText, Range.closed(13, 80),R.string.ageerr);

    }

    public void AddData() {
            Btn.setOnClickListener (new View.OnClickListener ( ) {
                @Override
                public void onClick(View v) {
                    int selectedId = radioGender.getCheckedRadioButtonId ( );
                    int selectedId1 = radioTime.getCheckedRadioButtonId ( );
                    rb1 = (RadioButton) findViewById (selectedId);

                    Toast.makeText (SignUp.this, rb1.getText ( ), Toast.LENGTH_SHORT).show ( );

                    rb2 = (RadioButton) findViewById (selectedId1);
                    Toast.makeText (SignUp.this, rb2.getText ( ), Toast.LENGTH_SHORT).show ( );

                    String message= cb.getText ().toString ();
                    String message1= cb1.getText ().toString ();
                    String message2= cb2.getText ().toString ();
                    String message3= cb3.getText ().toString ();
                    String message4= cb4.getText ().toString ();
                    String message5= cb5.getText ().toString ();
                    String message6= cb6.getText ().toString ();


                    if(!editname.getText ().toString ().isEmpty () || !editage.getText ().toString ().isEmpty ()){
                        //myDb.insertData1 (message,message1,message2,message3,message4,message5,message6);


                        healthilyPreference.setAccountName (editname.getText().toString ());
                        healthilyPreference.setAccountAge (editage.getText().toString ());
                        healthilyPreference.setAccountGender (rb1.getText().toString ());
                        healthilyPreference.setAccountPreferedTime (rb2.getText().toString ());
                        healthilyPreference.setAccountPreferedDate (message);
                        healthilyPreference.setAccountPreferedDate (message1);
                        healthilyPreference.setAccountPreferedDate (message2);
                        healthilyPreference.setAccountPreferedDate (message3);
                        healthilyPreference.setAccountPreferedDate (message4);
                        healthilyPreference.setAccountPreferedDate (message5);
                        healthilyPreference.setAccountPreferedDate (message6);


                    }else {
                        Toast.makeText (SignUp.this, "Enter name and age", Toast.LENGTH_SHORT).show ( );
                    }

                    healthilyPreference.hasLoggedIn (true);
                    /*
                           myDb.insertData1(cb.isChecked ()?1:0,cb1.isChecked ()?1:0,cb2.isChecked ()?1:0,cb3.isChecked ()?1:0,
                           cb4.isChecked ()?1:0, cb5.isChecked ()?1:0,cb6.isChecked ()?1:0);
                           */
                    /*boolean isInserted = myDb.insertData (editname.getText ( ).toString ( ), editage.getText ( ).toString ( ) );
                    if (isInserted == true)
                        Toast.makeText (SignUp.this, "Data Inserted", Toast.LENGTH_LONG).show ( );
                    else
                        Toast.makeText (SignUp.this, "Data not inserted", Toast.LENGTH_LONG).show ( );
*/
                    Intent startIntent = new Intent (SignUp.this, Category.class);
                    startActivity (startIntent);
                }
            });

        }

    }

