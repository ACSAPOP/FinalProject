package com.AndreaPop.Automation.utils;

import java.util.HashMap;
import java.util.Map;

public class UserHelper {
    public static Map<String, String> GenerateNewUserData() {
        String uniqueEmail = "andreaTest" + System.currentTimeMillis() + "@yahoo.com";
        String password = "TestPWD123";

        Map<String, String> credentials = new HashMap<>();
        credentials.put("email", uniqueEmail);
        credentials.put("password", password);
        return credentials;
    }
}
