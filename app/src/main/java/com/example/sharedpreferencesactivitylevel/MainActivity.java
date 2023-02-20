package com.example.sharedpreferencesactivitylevel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //declare which Tag has what id
    private EditText etName, etMajor, etId;
    private TextView txvName, txvMajor, txvId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get each element from ID (EditText)
        etName = findViewById(R.id.etName);
        etMajor = findViewById(R.id.etMajor);
        etId = findViewById(R.id.etId);
        //(TextView)
        txvName = findViewById(R.id.txvName);
        txvMajor = findViewById(R.id.txvMajor);
        txvId = findViewById(R.id.txvID);

    }

    //Button onClick (saveDate)
    public void saveData(View view) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        //save the data as key value pairs
        //getText from element by declared name => save as string
        editor.putString("name", etName.getText().toString());
        editor.putString("major", etMajor.getText().toString());
        editor.putString("Id", etId.getText().toString());

        //apply() saves data sync
        //editor.commit() saves data async
        editor.apply();
//        .commit returns a boolean indicating weather data was saved successfully or not.
//        Also editor.commit() saves data synchronously where editor.apply() saves the data asynchronously() runs in the background).
//        For this simple example it makes no difference which one you use.
    }
    //Button onClick (loadData)
    public void loadData(View view) {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);

        //retrieve the data from the shared preferences file
        //the second params are the default values you need to provide

        String name = sharedPreferences.getString("name", "Name is not available!");
        String major = sharedPreferences.getString("major", "Major is not available!");
        String Id = sharedPreferences.getString("Id", "Student ID is not Available!");

        //use the retrieved values to update the text views on the screen
        txvName.setText(name);
        txvMajor.setText(major);
        txvId.setText(Id);
    }
}