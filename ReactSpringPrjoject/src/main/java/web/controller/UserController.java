package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.service.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserService userService;


}
