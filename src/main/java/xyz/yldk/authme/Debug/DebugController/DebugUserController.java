package xyz.yldk.authme.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.yldk.authme.Daos.UserTableRepository;
import xyz.yldk.authme.Objects.JsonResult;

@RestController
@RequestMapping("debug/user")
public class DebugUserController {

    @Autowired
    private UserTableRepository userTableRepository;

    @RequestMapping("/getAllUser")
    @ResponseBody
    public JsonResult findAll() {
        JsonResult jsonResult = new JsonResult(
                200,
                "OK",
                userTableRepository.findAll()
        );
        return jsonResult;
    }

    @RequestMapping("/findUser")
    @ResponseBody
    public JsonResult findAll(@RequestParam("uid") Long personId) {
        JsonResult jsonResult = new JsonResult(
                200,
                "OK",
                userTableRepository.findByUid(personId)
        );
        return jsonResult;
    }

    @RequestMapping("/runtimeError")
    @ResponseBody
    public JsonResult makeRuntimeError() {
        JsonResult jsonResult = new JsonResult(
                200,
                "OK",
                null
        );
        throw new RuntimeException("Runtime error");
        //return jsonResult;
    }

}
