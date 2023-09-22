package xyz.yldk.authme.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.yldk.authme.Objects.JsonResult;

@RestController
public class MainController {

    @GetMapping("/")
    public JsonResult WebMain(){
        JsonResult jsonResult = new JsonResult(
                200,
                "OK",
                null
        );
        return jsonResult;

    }
}
