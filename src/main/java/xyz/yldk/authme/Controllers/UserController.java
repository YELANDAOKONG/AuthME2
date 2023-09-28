package xyz.yldk.authme.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.yldk.authme.Daos.EMailCodeTableRepository;
import xyz.yldk.authme.Daos.UserPasswordTableRepository;
import xyz.yldk.authme.Daos.UserTableRepository;
import xyz.yldk.authme.Objects.JsonResult;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserTableRepository userTableRepository;
    @Autowired
    private UserPasswordTableRepository userPasswordTableRepository;
    @Autowired
    private EMailCodeTableRepository userEmailCodeTableRepository;




}
