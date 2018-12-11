package com.example.assignment1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.support.design.widget.*;

import java.io.Console;
import java.net.URI;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent intent = getIntent();
        String Number = intent.getStringExtra("Message");
        String Name = intent.getStringExtra("Name");


        TextView name = findViewById(R.id.NameTextView);
        name.setText(Name);

        TextView message = findViewById(R.id.PhoneNumberTextView);
        message.setText(Number);
    }

    public void call(View view) {
        TextView Number = findViewById(R.id.PhoneNumberTextView);
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri uri = Uri.parse("tel:" + Number.getText().toString());
        intent.setData(uri);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }

    public void sendMessage(View view){
        TextView Number = findViewById(R.id.PhoneNumberTextView);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:"+Number.getText().toString()));
        startActivity(intent);
    }

    public void checkLocation(View view){
        TextView location = findViewById(R.id.LocationTextView);
        String loc = location.getText().toString();
        //Snackbar tt = Snackbar.make(view,"Do you want to Procees",Snackbar.LENGTH_LONG);
        Snackbar sn = Snackbar.make(view, "Do you want to proceed", Snackbar.LENGTH_LONG)
                .setAction("Yes", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Geocoder g  = new Geocoder(MainActivity);

                        Uri geoLocation = null;
                        try {
                            geoLocation = Uri.parse("geo:0,0?q="+loc);
                        } catch (Exception e) {
                            Log.e("Activity&Intent Example", "URI Exception");
                        }
                        Intent intent = new Intent(Intent.ACTION_VIEW,geoLocation);
                        //intent.setPackage()
                        if (intent.resolveActivity(getPackageManager()) != null) {
                            startActivity(intent);
                        }
                    }

                });

        sn.show();
    }
}
