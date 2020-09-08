package com.raj.androiddatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    EditText edt1,edt2;
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1= findViewById(R.id.add);
        Button b2= findViewById(R.id.display);
        final EditText edt1= findViewById(R.id.Fname);
        final EditText edt2= findViewById(R.id.Lname);
        db = new DatabaseHandler(this);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strfn = edt1.getText().toString();
                String strln = edt2.getText().toString();
                
                ContactModel contactModel = new ContactModel();//for store data
                contactModel.setFirstname(strfn);
                contactModel.setLastname(strln);
                db.insertRecord(contactModel);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,ListActivity.class);
                startActivity(i);
            }
        });
    }

}
