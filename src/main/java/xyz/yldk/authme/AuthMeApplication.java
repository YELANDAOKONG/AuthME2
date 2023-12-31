package xyz.yldk.authme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"xyz.yldk.authme"})
public class AuthMeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthMeApplication.class, args);
    }

}
