package com.raj.androiddatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

ListView listView;
ArrayList<LangModel> langModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        DatabaseHandler db = new DatabaseHandler(this);
        listView = (ListView) findViewById(R.id.listview);
        ArrayList<ContactModel> contactModels = db.getAllRecords();

        MyBaseAdapter myBaseAdapter = new
                MyBaseAdapter(this, contactModels);
        listView.setAdapter(myBaseAdapter);

    }
}




