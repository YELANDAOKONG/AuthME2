package xyz.yldk.authme.ENums;

import java.io.Serializable;

public enum UserPasswordTypes implements Serializable {
    UNKNOW(-1),
    DEFAULT(0),
    LIGHT(0),
    TSOA(1),
    ETSOA(2)

    ;

    private int value;

    UserPasswordTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
