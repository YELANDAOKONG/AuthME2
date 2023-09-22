package xyz.yldk.authme.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.yldk.authme.Daos.UserPasswordTableRepository;
import xyz.yldk.authme.Daos.UserTableRepository;
import xyz.yldk.authme.Entities.UserPasswordTable;
import xyz.yldk.authme.Entities.UserTable;
import xyz.yldk.authme.Objects.JsonResult;
import xyz.yldk.authme.Utils.PasswordUtils;

@RestController
@RequestMapping("debug/user")
public class DebugUserController {

    @Autowired
    private UserTableRepository userTableRepository;
    @Autowired
    private UserPasswordTableRepository userPasswordTableRepository;

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

    @RequestMapping("/testPwd1")
    @ResponseBody
    public JsonResult testPwd1(@RequestParam("uid") Long personId, @RequestParam("pwd") String pwd,
                               @RequestParam("type") Integer type) {
        userPasswordTableRepository.save(
                new UserPasswordTable(
                        personId,
                        pwd,
                        type
                )
        );
        JsonResult jsonResult = new JsonResult(
                200,
                "OK",
                userTableRepository.findByUid(personId)
        );
        return jsonResult;
    }


    @RequestMapping("/testPwd2")
    @ResponseBody
    public JsonResult testPwd2(@RequestParam("uid") Long personId, @RequestParam("pwd") String pwd) {
        UserPasswordTable upt = userPasswordTableRepository.findByUid(personId);
        if(upt == null){
            JsonResult jsonResult = new JsonResult(
                    403,
                    "UID Not Found",
                    null
            );
            return jsonResult;
        }

        JsonResult jsonResult = new JsonResult(
                200,
                "OK",
                PasswordUtils.checkUserPassword(upt,pwd)
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

    @RequestMapping("/newUser")
    @ResponseBody
    public JsonResult newUser(@RequestParam(value = "email", required = false, defaultValue = "test@test.cn")
                                  String email) {
        userTableRepository.save(
                new UserTable(
                        email,
                        0
                )
        );
        JsonResult jsonResult = new JsonResult(
                200,
                "OK",
                null
        );
        return jsonResult;
    }

}
