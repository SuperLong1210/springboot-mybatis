package com.springbootmybatisstater.mapper;

import com.springbootmybatisstater.enums.UserSexEnum;
import com.springbootmybatisstater.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户接口
 *
 * @author WangLonglong
 * @email caption1215@gmail.com
 * @date 2019/3/20 14:53
 */
public interface UserMapper {

    /**
     * 获得所有用户信息
     *
     * @return
     */
    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nikeName", column = "nick_name")
    })
    List<User> getAll();

    /**
     * 根据 ID 查询用户信息
     *
     * @param id
     * @return
     */
    @Select("SELECT * FROM users where id = #{id}")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nikeName", column = "nick_name")
    })
    User getOne(Long id);

    /**
     * 插入一条用户信息
     *
     * @param user
     */
    @Insert("INSERT INTO users(userName,passWord,user_sex) VALUES (#{userName},#{passWord},#{userSex})")
    void insert(User user);

    /**
     * 根据 ID 更新用户信息
     *
     * @param user
     */
    @Update("UPDATE users SET userName=#{userName},nike_name=#{nikeName} where id =#{id}")
    void update(User user);

    /**
     * 根据 ID 删除用户信息
     *
     * @param id
     */
    @Delete("DELETE FROM users WHERE id=#{id}")
    void delete(Long id);
}
