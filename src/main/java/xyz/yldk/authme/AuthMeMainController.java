package xyz.yldk.authme;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yldk.authme.Objects.JsonResult;

@RestController
public class AuthMeMainController {

    @GetMapping("/")
    public JsonResult WebMain(){
        JsonResult jsonResult = new JsonResult(
                200,
                "OK",
                null
        );
        return jsonResult;

    }

    @GetMapping("/error")
    public JsonResult ErrorHandler(){
        JsonResult jsonResult = new JsonResult(
                400,
                "Unknow Error",
                null
        );
        return jsonResult;

    }
}
