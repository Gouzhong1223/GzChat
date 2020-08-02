package com.gouzhong1223.gzchat.service.impl;

import com.gouzhong1223.gzchat.dto.ResponseDto;
import com.gouzhong1223.gzchat.service.MailService;
import com.gouzhong1223.gzchat.service.UserService;
import com.gouzhong1223.gzchat.utils.RandomNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

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

    public UserServiceImpl(MailService mailService, StringRedisTemplate stringRedisTemplate) {
        this.mailService = mailService;
        this.redisTemplate = stringRedisTemplate;
    }

    @Override
    public ResponseDto getVerificationCode(String emailAddress) {

        Integer number = RandomNumber.createNumber();
        redisTemplate.opsForValue().set(emailAddress, String.valueOf(number), 60 * 5, TimeUnit.SECONDS);
        mailService.sendSimpleMail(emailAddress, "GzChat注册验证码", "您好，您的验证码是:" + number + "\n请在 5 分钟之内完成注册，5 分钟后验证码将会失效");

//        // 判断邮箱是否已经被注册过
//        if (mailService.determineRegistered(emailAddress)) {
//            return new ResponseDto(ResultCode.ALREADYREGISTERED.getCode(), ResultMessage.ALREADYREGISTERED.getMessaage());
//        }

        return ResponseDto.SUCCESS();
    }
}
