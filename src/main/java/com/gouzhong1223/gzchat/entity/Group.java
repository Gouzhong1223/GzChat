package com.gouzhong1223.gzchat.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 群聊主键
     */
    private Integer id;
    /**
     * 群聊名称
     */
    private String groupName;
    /**
     * 群聊创建时间
     */
    private LocalDateTime createTime;
    /**
     * 群聊创建者 Id
     */
    private Integer holderId;
}
