package xyz.yldk.authme.Encryption.TripleSaltOffset;

import java.security.MessageDigest;


public class ETSOA {

    public static String run(String frontSalt, String middleSalt, String backSalt, int offsetValue, String password, int times){
        return enhancedTsoa(frontSalt, middleSalt, backSalt, offsetValue, password, times);
    }

    public static String build(String frontSalt, String middleSalt, String backSalt, int offsetValue, String password, int times){
        return enhancedTsoa(frontSalt, middleSalt, backSalt, offsetValue, password, times);
    }

    private static String enhancedTsoa(String frontSalt, String middleSalt, String backSalt, int offsetValue, String password, int times) {
        //If the number of operations is less than or equal to 0, return an empty string directly
        if (times <= 0) {
            //return "";
            return tsoa(frontSalt, middleSalt, backSalt, offsetValue, password);
        }
        //If the number of operations is equal to 1, call the tsoa method directly and return the result
        if (times == 1) {
            return tsoa(frontSalt, middleSalt, backSalt, offsetValue, password);
        }
        //Otherwise, loop for times times
        for (int i = 0; i < times; i++) {
            //Call the tsoa method and get the current encryption result
            String encryptedPassword = tsoa(frontSalt, middleSalt, backSalt, offsetValue, password);
            //Use the current encryption result as the next password
            password = encryptedPassword;
            //Perform tsoa operations between the three salts and get new three salts
            frontSalt = tsoa(frontSalt, middleSalt, backSalt, offsetValue + 1, frontSalt);
            middleSalt = tsoa(frontSalt, middleSalt, backSalt, offsetValue + 2, middleSalt);
            backSalt = tsoa(frontSalt, middleSalt, backSalt, offsetValue + 3, backSalt);
            //Increase the offset value by 1
            offsetValue++;
        }
        //Return the last encryption result
        return password;
    }

    //Define a method that accepts three salts, salt offset value and password to be encrypted, and returns an encrypted string
    private static String tsoa(String frontSalt, String middleSalt, String backSalt, int offsetValue, String password) {
        try {
            //Create a MessageDigest object for calculating SHA384 and SHA512
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            //First operation, take the SHA384 of the front salt and the SHA512 of the password, and splice them
            String data = sha384(md, frontSalt) + sha512(md, password);
            //Run the offset algorithm
            data = offset(data, offsetValue);
            //Second operation, take the SHA384 of the middle salt and the SHA512 of the previous operation result, and splice them
            data = sha512(md, data).substring(0, 64) + sha384(md, middleSalt) + sha512(md, data).substring(64);
            //Run the offset algorithm
            data = offset(data, offsetValue);
            //Third operation, take the SHA384 of the back salt and the SHA512 of the previous operation result, and splice them
            data = sha512(md, data) + sha384(md, backSalt);
            //Run the offset algorithm
            data = offset(data, offsetValue);
            //Take the SHA512 of the previous operation result to get the final saved value
            data = sha512(md, data);
            //Return result
            return data;
        } catch (Exception e) {
            //If an exception occurs, print the exception information and return an empty string
            e.printStackTrace();
            return "";
        }
    }

    //Define a helper method for calculating the SHA384 of a string
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

    //Define a helper method for implementing the offset algorithm
    public static String offset(String source, int value) {
        //If the source string is empty or the offset value is zero, return the source string directly
        if (source == null || source.length() == 0 || value == 0) {
            return source;
        }
        //Get the length of the source string
        int length = source.length();
        //Take modulo of offset value by length to get actual offset amount
        value = value % length;
        //If offset amount is negative, convert it to positive
        if (value < 0) {
            value = value + length;
        }
        //Split source string into two parts. The front part is substring from 0 to length-value-1, and the back part is substring from length-value to length-1
        String front = source.substring(0, length - value);
        String back = source.substring(length - value);
        //Splice the two parts together to get the offset string
        String result = back + front;
        //Return result
        return result;
    }

    //Define a method that accepts three salts, salt offset value, password to be encrypted and number of operations, and returns an encrypted string
    


}
