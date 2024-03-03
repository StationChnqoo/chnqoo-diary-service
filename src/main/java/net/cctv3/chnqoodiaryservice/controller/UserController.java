package net.cctv3.chnqoodiaryservice.controller;

import net.cctv3.chnqoodiaryservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 我估计是因为返回的String，所以SpringBoot默认的就是 text/plain 了 ...
     * 所以以后都自己手动加上吧
     * produces = "application/json;charset=UTF-8" ...
     * */
    @CrossOrigin
    @GetMapping(value = {"/sendSms.do"}, produces = "application/json;charset=UTF-8")
    public String sendSms(@RequestParam String mobile, HttpServletRequest request) {
        return userService.sendSms(mobile);
    }

    @CrossOrigin
    @GetMapping(value = {"/checkSms.do"}, produces = "application/json;charset=UTF-8")
    public String checkSms(@RequestParam String mobile, @RequestParam String code, HttpServletRequest request) {
        return userService.checkSms(mobile, code);
    }
}