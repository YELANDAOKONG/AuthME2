package xyz.yldk.authme.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.io.Serializable;

public class EMailCodeTable implements Serializable {

    @Column(name = "email")
    private String email;

    @Column(name = "time")
    private Long time;

    @Column(name = "code")
    private Long code;

    public EMailCodeTable(){
        super();
    }

    public EMailCodeTable(String email, Long code){
        super();
        this.email = email;
        this.code = code;
        this.time = System.currentTimeMillis();
    }


    public EMailCodeTable(String email ,Long time, Long code){
        super();
        this.email = email;
        this.code = code;
        this.time = time;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }



}
