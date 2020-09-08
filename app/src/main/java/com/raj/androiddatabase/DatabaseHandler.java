package com.raj.androiddatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "SQLiteDatabse.db"; /* you can set any name with .db */
    public static final String TABLE_NAME = "Pepole";
    public static final String COLUMN_ID = "ID";
    public static final String FIRST_NAME = "FIRST_NAME";
    public static final String LAST_NAME = "LAST_NAME";
    private SQLiteDatabase database;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //    for create table into database
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +
                " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + FIRST_NAME + " VARCHAR, "
                + LAST_NAME + " VARCHAR);");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //    for insert data
    public void insertRecord(ContactModel contact) {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME, contact.getFirstname());
        contentValues.put(LAST_NAME, contact.getLastname());
        database.insert(TABLE_NAME, null, contentValues);
        database.close();
    }

    public ArrayList<ContactModel> getAllRecords() {
        database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME,
                null, null, null, null, null, null);//For fething data
        ArrayList<ContactModel> contactModels = new ArrayList<ContactModel>();
        ContactModel contactModel;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                contactModel = new ContactModel();
                contactModel.setID(cursor.getString(0));
                contactModel.setFirstname(cursor.getString(1));
                contactModel.setLastname(cursor.getString(2));
                contactModels.add(contactModel);

            }
        }
        cursor.close();
        database.close();
        return contactModels;
    }

    public void updateRecord(ContactModel contactModel){
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FIRST_NAME, contactModel.getFirstname());
        contentValues.put(LAST_NAME, contactModel.getLastname());
        database.update(TABLE_NAME , contentValues , COLUMN_ID + " = ?",
                new String[]{contactModel.getID()});
        database.close();
    }

    public void deleteRecord(ContactModel contactModel){
        database = this.getReadableDatabase();
        database.delete(TABLE_NAME, COLUMN_ID + " = ? ", new String[]{contactModel.getID()});
        database.close();
    }
}
