package com.gouzhong1223.gzchat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description :
 * @Date : create by QingSong in 2020-08-01 11:48 下午
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
public class UserMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户主键
     */
    private Integer userId;
    /**
     * 消息 Id
     */
    private Integer messageId;
    /**
     * 是否已读 0->未读 1->已读
     */
    private Integer read;
}
