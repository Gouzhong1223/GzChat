package com.gouzhong1223.gzchat.service;

import com.gouzhong1223.gzchat.dto.ResponseDto;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : UserService
 * @Date : create by QingSong in 2020-07-12 12:01 上午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.gzchat.service
 * @ProjectName : gzchat
 * @Version : 1.0.0
 */
public interface UserService {

    /**
     * 根据邮箱生成验证码
     *
     * @param emailAddress 邮箱地址
     * @return
     */
    ResponseDto getVerificationCode(String emailAddress);

    /**
     * 用户注册
     *
     * @param username         用户名
     * @param password         密码
     * @param verificationCode 验证码
     * @param emailAddress     邮箱地址
     * @return
     */
    ResponseDto registerUser(String username, String password, String emailAddress, String verificationCode);

}
