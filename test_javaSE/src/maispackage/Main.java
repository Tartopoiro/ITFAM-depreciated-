package maispackage;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.naming.Context;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception {

        String value = "test";
        System.out.println(value);

        value = Crypto.encrypt(value);

        System.out.println(value);

        value = Crypto.decrypt(value);

        System.out.println(value);

    }










}