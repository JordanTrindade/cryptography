package com.app.cryptography.service;

import org.jasypt.util.text.StrongTextEncryptor;

public class CryptographyService {
    private final static StrongTextEncryptor textEncriptor;

    static {
         textEncriptor = new StrongTextEncryptor();
         textEncriptor.setPassword(System.getenv("SECRET-KEY"));
    }

    public static String encript(String rawText) {
        return textEncriptor.encrypt(rawText);
    }

    public static String decript(String encripString) {
        return textEncriptor.decrypt(encripString);
    }

}
