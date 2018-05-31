package com.example.hane7366.mycontactapp;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MenuScreen extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName;
    EditText editGender;
    EditText editBloodType;
    EditText editQuery;
    private String derp;

    @Override
    public <T extends View> T findViewById(int id) {
        return super.findViewById(id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        editName = findViewById(R.id.editText_name);

        myDb = new DatabaseHelper(this);
        Log.d("MyContactApp","MenuScreen:  instantiation");
    }
    public void addData(View view){

        Log.d("MyContactApp", "DatabaseHelper:  adding data");

        boolean isInserted = myDb.insertData(editName.getText().toString());

    }

    public void viewData (View view){
        Cursor res = myDb.getAllData();
        Log.d("MyContactApp", "MainActivity:  viewData: recieved cursor");

        if (res.getCount()==0){
            showMessage("Error", "No data found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while(res.moveToNext()){

        }
        showMessage("Data", buffer.toString());
    }

    private void showMessage(String title, String message) {
        Log.d("MyContactApp", "MainActivity: assembling and showing message");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public static final String EXTRA_MESSAGE = "com.example.hane7366.mycontactapp";
    public void searchRecord(View view){
        Log.d("MyContactApp", "MainActivity:  launching SearchActivity");
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra(EXTRA_MESSAGE, editName.getText().toString());
        startActivity(intent);
    }

}
