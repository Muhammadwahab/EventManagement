package com.example.a4slashdevelopers.eventmanagement.UTIL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 4slashDevelopers on 1/4/2018.
 */

public class utilityClass {
    public static final String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";

    public static Matcher regularExpression(String email)
    {
        return Pattern.compile(regex).matcher(email);

    }
}
