package com.app.cryptography.service;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;
import org.springframework.stereotype.Service;

public class cryptographyService {
    private final static StrongTextEncryptor textEncriptor;

    static {
         textEncriptor = new StrongTextEncryptor();
         textEncriptor.setPassword(System.getenv("SECRET-KEY"));
    }

}
