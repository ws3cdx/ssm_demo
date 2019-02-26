package com.ws3cdx.dao;

import com.ws3cdx.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Select("SELECT * FROM s_user WHERE username = #{username} AND password = #{password}")
    User checkUser(@Param("username")String username,@Param("password")String password);

    @Delete("DELETE FROM s_cust WHERE cid = #{id}")
    int delectById(Integer id);

    @Select("SELECT * FROM s_user")
    List<User> showAll();

    @Select("SELECT * FROM s_user WHERE uid = #{uid}")
    User chechUserByUId(String uid);
}
