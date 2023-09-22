package xyz.yldk.authme.Encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LightWeightAlgorithm {


    public static String sha384(MessageDigest md, String input) {
        //Convert the input string to a byte array
        byte[] bytes = input.getBytes();
        //Update the state of the MessageDigest object
        md.update(bytes);
        //Calculate the digest of the MessageDigest object and convert it to a hexadecimal string
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        //Return result
        return sb.toString();
    }

    //Define a helper method for calculating the SHA512 of a string
    public static String sha512(MessageDigest md, String input) {
        //Convert the input string to a byte array
        byte[] bytes = input.getBytes();
        //Update the state of the MessageDigest object
        md.update(bytes);
        //Calculate the digest of the MessageDigest object and convert it to a hexadecimal string
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        //Return result
        return sb.toString();
    }

    // Hash加盐算法，在密码后面加盐hash

    public static String run(String password,String salt){
        try{
            return sha512(MessageDigest.getInstance("SHA-512"),salt + password + salt);

        } catch (NoSuchAlgorithmException e) {
            //throw new RuntimeException(e);
            //If an exception occurs, print the exception information and return an empty string
            e.printStackTrace();
            return "";
        }
    }



















}
