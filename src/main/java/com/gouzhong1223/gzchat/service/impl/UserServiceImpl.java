package com.gouzhong1223.gzchat.service.impl;

import com.gouzhong1223.gzchat.common.ResultCode;
import com.gouzhong1223.gzchat.common.ResultMessage;
import com.gouzhong1223.gzchat.dto.ResponseDto;
import com.gouzhong1223.gzchat.entity.User;
import com.gouzhong1223.gzchat.mapper.UserMapper;
import com.gouzhong1223.gzchat.service.MailService;
import com.gouzhong1223.gzchat.service.UserService;
import com.gouzhong1223.gzchat.utils.MD5Util;
import com.gouzhong1223.gzchat.utils.RandomNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : {@link UserService} 实现类
 * @Date : create by QingSong in 2020-07-12 12:01 上午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.gzchat.service.impl
 * @ProjectName : gzchat
 * @Version : 1.0.0
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final MailService mailService;
    private final StringRedisTemplate redisTemplate;
    private final UserMapper userMapper;

    public UserServiceImpl(MailService mailService, StringRedisTemplate stringRedisTemplate, UserMapper userMapper) {
        this.mailService = mailService;
        this.redisTemplate = stringRedisTemplate;
        this.userMapper = userMapper;
    }

    @Override
    public ResponseDto getVerificationCode(String emailAddress) {

        Integer number = RandomNumber.createNumber();
        redisTemplate.opsForValue().set(emailAddress, String.valueOf(number), 60 * 5, TimeUnit.SECONDS);
        mailService.sendSimpleMail(emailAddress, "GzChat注册验证码", "您好，您的验证码是:" + number + "\n请在 5 分钟之内完成注册，5 分钟后验证码将会失效");
        return ResponseDto.SUCCESS();
    }

    @Override
    public ResponseDto registerUser(String username, String password, String emailAddress, String verificationCode) {
        // 判断邮箱是否已经被注册过
        if (mailService.determineRegistered(emailAddress)) {
            return new ResponseDto(ResultCode.ALREADYREGISTERED.getCode(), ResultMessage.ALREADYREGISTERED.getMessaage());
        }
        String code = redisTemplate.opsForValue().get(emailAddress);
        // 判断验证码是否正确
        if (code != verificationCode) {
            return new ResponseDto(ResultCode.VERIFICATIONCODEERROR.getCode(), ResultMessage.VERIFICATIONCODEERROR.getMessaage());
        }
        User record = new User(null, username, MD5Util.code(password), emailAddress, LocalDateTime.now());
        userMapper.insertSelective(record);
        return ResponseDto.SUCCESS(record);
    }

}
