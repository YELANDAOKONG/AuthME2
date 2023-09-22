package xyz.yldk.authme.ENums;

import java.io.Serializable;

public enum UserPasswordStatus implements Serializable {
    UNKNOWN(-1),
    NORMAL(0),
    EXPIRED(1),



    ;



    private int value;
    UserPasswordStatus(int value) {
        this.value = value;
    }

    public int getStatus() {
        return value;
    }

}
