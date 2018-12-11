package com.example.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class nameActivity extends AppCompatActivity {

//    public static final String EXTRA_MESSAGE = "EXAMPLE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
    }

    public void sendName(View view){
        Intent intent = new Intent(this,phoneNumber.class);
        EditText name = (EditText) findViewById(R.id.NameTextView);
        if (TextUtils.isEmpty(name.getText()) )
        {
            name.setError("Name is Required");
        }
        else{
            String message = name.getText().toString();
            intent.putExtra("EXTRA_MESSAGE",message);
            startActivityForResult(intent,2);
        }

    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == 2){
            String Number = data.getStringExtra("Name");
            String Name = data.getStringExtra("Number");
            Intent intent = new Intent();
            Bundle extra = new Bundle();
            extra.putString("Name",Name);
            extra.putString("Number",Number);
            intent.putExtras(extra);
            setResult(1,intent);
            finish();
        }
    }
}
