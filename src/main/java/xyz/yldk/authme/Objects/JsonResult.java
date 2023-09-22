package xyz.yldk.authme.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
public class JsonResult implements Serializable {

    public Integer code;
    public Long time;
    public String uuid;
    public String message;
    public Object data;

    public JsonResult(Integer code, Long time, String uuid, String message, Object data) {
        this.code = code;
        this.time = time;
        this.uuid = uuid;
        this.message = message;
        this.data = data;
    }

    public JsonResult(Integer code, String message, Object data) {
        this.code = code;
        this.time = new Date().getTime();
        this.uuid = UUID.randomUUID().toString();
        this.message = message;
        this.data = data;
    }

    public JsonResult() {
        this.code = 200;
        this.time = new Date().getTime();
        this.uuid = UUID.randomUUID().toString();
        this.message = "OK";
        this.data = null;
    }











}
