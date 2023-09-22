package xyz.yldk.authme.Entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "user")
public class UserTable implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

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



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
