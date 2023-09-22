package xyz.yldk.authme.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import xyz.yldk.authme.Encryption.LightWeightAlgorithm;
import xyz.yldk.authme.Encryption.TripleSaltOffset.ETSOA;
import xyz.yldk.authme.Encryption.TripleSaltOffset.TSOA;
import xyz.yldk.authme.Entities.UserPasswordTable;

import java.util.UUID;

@Component
public class PasswordUtils {

    public static Integer RANDOM_OFFSET_MIN = 20;
    public static Integer RANDOM_OFFSET_MAX = 50;
    public static Integer RANDOM_COUNT_MIN = 10;
    public static Integer RANDOM_COUNT_MAX = 20;

    @Value("${authme.password.random_offset.min:20}")
    public void setRandomOffsetMin(Integer randomOffsetMin) {
        RANDOM_OFFSET_MIN = randomOffsetMin;
    }
    @Value("${authme.password.random_offset.max:50}")
    public void setRandomOffsetMax(Integer randomOffsetMax) {
        RANDOM_OFFSET_MAX = randomOffsetMax;
    }
    @Value("${authme.password.random_count.min:10}")
    public void setRandomCountMin(Integer randomCountMin) {
        RANDOM_COUNT_MIN = randomCountMin;
    }
    @Value("${authme.password.random_count.max:20}")
    public void setRandomCountMax(Integer randomCountMax) {
        RANDOM_COUNT_MAX = randomCountMax;
    }




    public static String randomSaltString(){
        String salt = String.format("%s%s%s",UUID.randomUUID().toString(),UUID.randomUUID().toString(),UUID.randomUUID().toString());
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

    public static boolean checkUserPassword(UserPasswordTable userPasswordTable, String password){

        if(userPasswordTable == null || password == null){
            return false;
        }

        if(userPasswordTable.getType() == 1){
            String pwd = TSOA.run(
                    userPasswordTable.getSaltFront(),
                    userPasswordTable.getSaltMiddle(),
                    userPasswordTable.getSaltBack(),
                    userPasswordTable.getSaltOffsetValue(),
                    password
            );
            if(pwd.equals(userPasswordTable.getPassword())){
                return true;
            }
            return false;
        }

        if(userPasswordTable.getType() == 2){
            String pwd = ETSOA.run(
                    userPasswordTable.getSaltFront(),
                    userPasswordTable.getSaltMiddle(),
                    userPasswordTable.getSaltBack(),
                    userPasswordTable.getSaltOffsetValue(),
                    password,
                    userPasswordTable.getSaltCount()
            );
            if(pwd.equals(userPasswordTable.getPassword())){
                return true;
            }
            return false;
        }

        String pwd = LightWeightAlgorithm.run(password, userPasswordTable.getSaltMiddle());
        if(pwd.equals(userPasswordTable.getPassword())){
            return true;
        }
        return false;

    }


}
