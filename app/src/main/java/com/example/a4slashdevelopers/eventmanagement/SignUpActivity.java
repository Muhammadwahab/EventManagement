package com.example.a4slashdevelopers.eventmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_account);
        mAuth = FirebaseAuth.getInstance();
    }


    public void signupaccount(View view)
    {

        isEmailValidate( ((EditText)findViewById(R.id.emailidsignup)).getText().toString().trim());

    }
    void isEmailValidate(String email)
    {

            String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches()) {
                Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this, "valid Email", Toast.LENGTH_SHORT).show();

    }
}
