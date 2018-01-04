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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    public static String message="/**\n" +
            "\t  * returns true if the provided password\n" +
            "\t  * \n" +
            "\t  * \t- contains at least 1 digit\n" +
            "\t  * \t- contains at least 1 lowercase letter\n" +
            "\t  * \t- contains at least 1 uppercase letter\n" +
            "\t  * \t- contains at least 1 of the special \n" +
            "\t  * \t\tcharacters !@#$%^&*()_+\\-=[]{};':\"\\|,.<>/?\n" +
            "\t  * \t- is at least 6 character long\n" +
            "\t  * \t- is at most 15 characters long  \n" +
            "\t  * \t(note : for best practices you could even set \n" +
            "\t  * \tthe max length to a higher value ) \n" +
            "\t  * \n" +
            "\t  * @param password the password to validate\n" +
            "\t  * @return true if the password validates\n" +
            "\t  */";
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
            if (!utilityClass.regularExpression(email).matches())
                Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
            else
                ispasswordValidate(((EditText)findViewById(R.id.passwordidsignup)).getText().toString().trim(),((EditText)findViewById(R.id.confirmpasswordidsignup)).getText().toString().trim(),email);
    }
    void ispasswordValidate(String password, String confirmpassword, String email){

        final String PASSWORD_REGEXP =
                "^"
                        + "(?=.*\\d)"
                        + "(?=.*[a-z])"
                        + "(?=.*[A-Z])"
                        + "(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?])"
                        + "."
                        + "{6,15}"
                        + "$";

         Pattern pattern = Pattern.compile(PASSWORD_REGEXP);
         Matcher matcher;

        matcher = pattern.matcher(password);
         if (matcher.matches())
         {
             Toast.makeText(this, "valid", Toast.LENGTH_SHORT).show();
             // password matching with confirm password
             if (password.equals(confirmpassword))
             {
                 // password match hua to
                 // Firebase Methods call

                 signup(email,password);
             }
             else
             {
                 // password did not match
             }




         }
         else
         {
             Toast.makeText(this, message, Toast.LENGTH_LONG).show();

         }

    }

    private void signup(String email,String password) {

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.e("SIGNUP", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            // insert new user in database list

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.e("SIGNUP", "createUserWithEmail:failure", task.getException());
                        }

                        // ...
                    }
                });
    }
}
