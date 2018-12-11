package com.example.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class phoneNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);

    }

    public void openNumberActivity(View view){
        //getting name from previous activity
        Intent intent = getIntent();
        EditText Number = findViewById(R.id.PhoneNumberText);
        String name = intent.getStringExtra("EXTRA_MESSAGE");
        Bundle extra = new Bundle();

        String number = Number.getText().toString();
        if (TextUtils.isEmpty(number)){
            Number.setError("Number is required");
        }
        else{

            //putting in name and phone number in intent object
            extra.putString("Name",name);
            extra.putString("Number",number);
            intent.putExtras(extra);
            setResult(1,intent);
            finish();
        }

    }
}
