package com.raj.androiddatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FinalActivity extends AppCompatActivity {

    EditText edt1,edt2;
    String sId,sID2;
    Button b1,b2;
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        final EditText edt1 = findViewById(R.id.e1);
        final EditText edt2 = findViewById(R.id.e2);

        sId = getIntent().getStringExtra("fnamekey");
        sID2= getIntent().getStringExtra("lnamekey");
        final String strid = getIntent().getStringExtra("idkey");
        db = new DatabaseHandler(this);

        edt1.setText(sId);
        edt2.setText(sID2);


        b1 = findViewById(R.id.update);
        b2 = findViewById(R.id.delete);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strfn = edt1.getText().toString();
                String strln = edt2.getText().toString();

                ContactModel contactModel = new ContactModel();
                contactModel.setID(strid);
                contactModel.setFirstname(strfn);
                contactModel.setLastname(strln);
                db.updateRecord(contactModel);
                Intent i = new Intent(FinalActivity.this,ListActivity.class);
                startActivity(i);
                Toast.makeText(FinalActivity.this, "Update button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContactModel contactModel = new ContactModel();
                contactModel.setID(strid);
                db.deleteRecord(contactModel);
                Intent i = new Intent(FinalActivity.this,ListActivity.class);
                startActivity(i);
                Toast.makeText(FinalActivity.this, "Delete button clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
