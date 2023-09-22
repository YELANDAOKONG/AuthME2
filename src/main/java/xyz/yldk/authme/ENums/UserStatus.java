package xyz.yldk.authme.ENums;

import java.io.Serializable;

public enum UserStatus implements Serializable {
    UNKNOWN(-1),
    NORMAL(0),
    BANNED(1),
    DELETED(2),
    PROTECTED(3)


    ;



    private int value;
    UserStatus(int value) {
        this.value = value;
    }

    public int getStatus() {
        return value;
    }


}
