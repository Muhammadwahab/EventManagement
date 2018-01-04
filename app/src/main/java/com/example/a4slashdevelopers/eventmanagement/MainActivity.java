package com.example.a4slashdevelopers.eventmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a4slashdevelopers.eventmanagement.UTIL.utilityClass;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        Toast.makeText(this, currentUser==null?"User Not Sign in":"User is Sign in", Toast.LENGTH_SHORT).show();

    }

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
        if (!utilityClass.regularExpression(email).matches())
            Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
        else
        {
            // valid int a
        }


    }
}
