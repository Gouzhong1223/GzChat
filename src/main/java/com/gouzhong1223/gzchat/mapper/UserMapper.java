package com.gouzhong1223.gzchat.mapper;

import com.gouzhong1223.gzchat.entity.User;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : UserMapper
 * @Date : create by QingSong in 2020-08-01 11:24 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.gzchat.mapper
 * @ProjectName : gzchat
 * @Version : 1.0.0
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
