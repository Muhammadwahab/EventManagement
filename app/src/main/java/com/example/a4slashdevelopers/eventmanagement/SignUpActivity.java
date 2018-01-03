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
        ispasswordValidate(((EditText)findViewById(R.id.passwordidsignup)).getText().toString().trim(),((EditText)findViewById(R.id.confirmpasswordidsignup)).getText().toString().trim());
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
    void ispasswordValidate(String password,String confirmpassword){

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
                 // password match
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
}
