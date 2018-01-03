package com.example.a4slashdevelopers.eventmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void signupactivity(View view)
    {
        startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
        finish();

    }
    public void loginonclick(View view)
    {
         signin(((EditText)(findViewById(R.id.emailidsignin))).getText().toString().trim(), ((EditText)(findViewById(R.id.passwordidsignin))).getText().toString().trim());

    }

    private void signin(String email, String password) {

    }
}
