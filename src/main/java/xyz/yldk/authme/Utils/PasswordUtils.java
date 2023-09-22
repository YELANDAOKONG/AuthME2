package xyz.yldk.authme.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PasswordUtils {

    @Value("${authme.password.random_offset.min:20}")
    public static Integer RANDOM_OFFSET_MIN = 20;
    @Value("${authme.password.random_offset.max:50}")
    public static Integer RANDOM_OFFSET_MAX = 50;

    @Value("${authme.password.random_count.min:10}")
    public static Integer RANDOM_COUNT_MIN = 10;
    @Value("${authme.password.random_count.max:20}")
    public static Integer RANDOM_COUNT_MAX = 20;

    public static String randomSaltString(){
        String salt = String.format("{}{}{}",UUID.randomUUID().toString(),UUID.randomUUID().toString(),UUID.randomUUID().toString());
        return salt;
        //String salt = "";
        //salt = salt + UUID.randomUUID().toString();
        //salt = salt + UUID.randomUUID().toString();
        //salt = salt + UUID.randomUUID().toString();
        //return salt;
    }

    public static int randomOffset(){
        int min = RANDOM_OFFSET_MIN;
        int max = RANDOM_OFFSET_MAX;

        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static int randomCount(){
        int min = RANDOM_COUNT_MIN;
        int max = RANDOM_COUNT_MAX;

        return (int) (Math.random() * (max - min + 1) + min);
    }
}
