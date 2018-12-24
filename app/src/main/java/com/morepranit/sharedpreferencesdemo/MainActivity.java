package com.morepranit.sharedpreferencesdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sp = getSharedPreferences("user", Context.MODE_PRIVATE);
        boolean isLoggedIn = sp.getBoolean("is_logged_in", false);
        if (!isLoggedIn) {
            goToLogin();
        }

        setContentView(R.layout.activity_main);
    }

    public void onLogout(View view) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("is_logged_in", false);
        editor.commit();

        goToLogin();
    }

    private void goToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
