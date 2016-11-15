package com.testqr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.qrmodule.QRMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnShow(View view) {
        Intent intent = new Intent(MainActivity.this, QRMainActivity.class);
        startActivity(intent);
    }

}
