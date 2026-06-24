package com.ecom.user.utils;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class PasswordHelper {
    public static String hashPassword(String password){
        return BCrypt.hashpw(password, BCrypt.gensalt(10));
    }
    public static boolean checkPassword(String password, String hashedPassword){
        return BCrypt.checkpw(password, hashedPassword);
    }
}
