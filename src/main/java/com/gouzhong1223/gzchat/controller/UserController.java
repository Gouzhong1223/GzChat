package com.gouzhong1223.gzchat.controller;

import com.gouzhong1223.gzchat.dto.ResponseDto;
import com.gouzhong1223.gzchat.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : 用户服务控制器
 * @Date : create by QingSong in 2020-07-12 12:00 上午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.gzchat.controller
 * @ProjectName : gzchat
 * @Version : 1.0.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/vercode/{email}")
    public ResponseDto getVerificationCode(@PathVariable("email") String email) {

        return null;
    }
}
