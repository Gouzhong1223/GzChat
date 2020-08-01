package com.gouzhong1223.gzchat.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description :
 * @Date : create by QingSong in 2020-08-01 11:47 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.gzchat.entity
 * @ProjectName : gzchat
 * @Version : 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message implements Serializable {
    /**
     * 消息主键
     */
    private Integer id;

    /**
     * 消息内容
     */
    private String context;

    /**
     * 消息创建时间
     */
    private LocalDateTime createTime;

    /**
     * 发送人 Id
     */
    private Integer sendUserId;

    /**
     * 发送人用户名
     */
    private String sendUserName;

    /**
     * 是否为群聊信息
     */
    private Integer groupChat;

    /**
     * 接收人 Id
     */
    private Integer acceptUserId;

    private static final long serialVersionUID = 1L;
}
