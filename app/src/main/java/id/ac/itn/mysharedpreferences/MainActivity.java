package id.ac.itn.mysharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Home");
        }
        final TextView textView = findViewById(R.id.textView);
        final Button logoutbutton = findViewById(R.id.btnLogout);
        final SharedPrefManager prefManager = new SharedPrefManager(this);
        if (!prefManager.isUserLoggedIn()) {
            backToLogin();
        }
        UserModel user = prefManager.getUserLogin();
        textView.setText(getString(R.string.welcome, user.getUserName()));
        logoutbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefManager.userLogout();
                backToLogin();
            }
        });
    }

    private void backToLogin() {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }
}