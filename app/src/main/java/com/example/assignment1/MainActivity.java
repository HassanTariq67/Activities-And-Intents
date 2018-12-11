package com.example.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String Name = "";
    public static String Number = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startNameActivity(View view){
        Intent intent = new Intent(this,nameActivity.class);
        startActivityForResult(intent,1);
    }

    public void startMapActivity(View view)
    {
        Intent intent = new Intent(this,MapActivity.class);
        Bundle extra = new Bundle();
        extra.putString("Name",Number);
        extra.putString("Message",Name);
        intent.putExtras(extra);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (requestCode == 1)
        {
            Name = data.getStringExtra("Name");
            Number = data.getStringExtra("Number");
        }

    }
}
