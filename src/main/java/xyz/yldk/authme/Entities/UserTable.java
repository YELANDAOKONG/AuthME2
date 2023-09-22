package xyz.yldk.authme.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "user")
public class UserTable implements Serializable {

    @Id
    @GeneratedValue
    private Long uid;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private Integer status;

    public UserTable(){
        super();
    }

    public UserTable(String email, Integer status){
        super();
        this.email = email;
        this.status = status;
    }



    public Long getUid() {
        return uid;
    }

    public void setUid(Long id) {
        this.uid = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }






}
