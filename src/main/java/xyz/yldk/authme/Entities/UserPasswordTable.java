package xyz.yldk.authme.Entities;

import jakarta.persistence.*;
import lombok.Data;
import xyz.yldk.authme.ENums.UserPasswordStatus;
import xyz.yldk.authme.Encryption.LightWeightAlgorithm;
import xyz.yldk.authme.Encryption.TripleSaltOffset.ETSOA;
import xyz.yldk.authme.Encryption.TripleSaltOffset.TSOA;
import xyz.yldk.authme.Utils.PasswordUtils;

import java.util.Date;

@Data
@Entity
@Table(name = "user_password")
public class UserPasswordTable {

    @Id
    //@GeneratedValue
    private Long uid;

    @Column(name = "status")
    private Integer status;

    @Column(name = "time")
    private Long time;

    @Column(name = "password")
    private String password;

    // Password Encryption Algorithm

    @Column(name = "type")
    private Integer type;

    @Column(name = "salt_front")
    private String saltFront;

    @Column(name = "salt_middle")
    private String saltMiddle;

    @Column(name = "salt_back")
    private String saltBack;

    @Column(name = "salt_offset_value")
    private Integer saltOffsetValue;

    @Column(name = "salt_count")
    private Integer saltCount;

    public UserPasswordTable(){
        super();
    }

    public UserPasswordTable(Long uid, Integer status, Long time, String password, Integer type, String saltFront, String saltMiddle,
                             String saltBack, Integer saltOffsetValue, Integer saltCount) {
        this.uid = uid;
        this.status = status;
        this.time = time;
        this.password = password;
        this.type = type;
        this.saltFront = saltFront;
        this.saltMiddle = saltMiddle;
        this.saltBack = saltBack;
        this.saltOffsetValue = saltOffsetValue;
        this.saltCount = saltCount;
    }

    public UserPasswordTable(Long uid, String password, Integer type) {
        this.uid = uid;
        this.status = UserPasswordStatus.NORMAL.getStatus();
        this.time = new Date().getTime();
        this.password = password;
        this.type = 0;

        if(type == 1){
            this.type = 1;
            this.saltFront = PasswordUtils.randomSaltString();
            this.saltMiddle = PasswordUtils.randomSaltString();
            this.saltBack = PasswordUtils.randomSaltString();
            this.saltOffsetValue = PasswordUtils.randomOffset();
            this.saltCount = 0;

            this.password = TSOA.run(
                    this.saltFront,
                    this.saltMiddle,
                    this.saltBack,
                    this.saltOffsetValue,
                    password
            );
            return;
        }
        if(type == 2){
            this.type = 2;
            this.saltFront = PasswordUtils.randomSaltString();
            this.saltMiddle = PasswordUtils.randomSaltString();
            this.saltBack = PasswordUtils.randomSaltString();
            this.saltOffsetValue = PasswordUtils.randomOffset();
            this.saltCount = PasswordUtils.randomCount();

            this.password = ETSOA.run(
                    this.saltFront,
                    this.saltMiddle,
                    this.saltBack,
                    this.saltOffsetValue,
                    password,
                    saltCount
            );
            return;
        }

        this.saltFront = null;
        this.saltMiddle = PasswordUtils.randomSaltString();
        this.saltBack = null;
        this.saltOffsetValue = 0;
        this.saltCount = 0;
        this.password = LightWeightAlgorithm.run(password, this.saltMiddle);




    }









}
