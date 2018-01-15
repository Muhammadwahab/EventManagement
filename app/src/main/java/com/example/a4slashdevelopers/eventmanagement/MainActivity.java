package com.example.a4slashdevelopers.eventmanagement;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a4slashdevelopers.eventmanagement.UTIL.utilityClass;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
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
            if (passwordValidation(password)==true)
                // firebase sign in method call
                firebaseEmailAndPasswordSignin(email,password);
                else
            Toast.makeText(this, "Password Should Be Equal To And Greator Then 6", Toast.LENGTH_SHORT).show();

        }


    }

    private void firebaseEmailAndPasswordSignin(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Signin", "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            // check email verification
<<<<<<< HEAD
                            startActivity(new Intent(getApplicationContext(),startactivity.class));
                            Toast.makeText(MainActivity.this, "User Sign is Successfully"+user.getEmail(), Toast.LENGTH_SHORT).show();
=======
                            if (user.isEmailVerified())
                                Toast.makeText(MainActivity.this, "User Sign is Successfully"+user.getEmail(), Toast.LENGTH_SHORT).show();
                            else
                                Toast.makeText(MainActivity.this, "please verify email "+user.getEmail(), Toast.LENGTH_SHORT).show();

>>>>>>> 17f5151dd16e04c0e6ea8a13a791c10b46e3559b
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Signin", "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    private boolean passwordValidation(String password) {
        if (password.length()>=6)
            return true;
        else
            return false;
    }
}
