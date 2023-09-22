package xyz.yldk.authme.Encryption;

public class OffsetAlgorithm {
    public static String offset(String source, int value) {
        if (source == null || source.length() == 0 || value == 0) {
            return source;
        }
        int length = source.length();
        value = value % length;
        if (value < 0) {
            value = value + length;
        }
        String front = source.substring(0, length - value);
        String back = source.substring(length - value);
        String result = back + front;
        return result;
    }

}
