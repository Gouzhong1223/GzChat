package com.gouzhong1223.gzchat.mapper;

import com.gouzhong1223.gzchat.entity.UserGroup;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description :
 * @Date : create by QingSong in 2020-08-01 11:48 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.gzchat.mapper
 * @ProjectName : gzchat
 * @Version : 1.0.0
 */
public interface UserGroupMapper {
    int insert(UserGroup record);

    int insertSelective(UserGroup record);
}
