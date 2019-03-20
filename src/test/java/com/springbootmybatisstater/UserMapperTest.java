package com.springbootmybatisstater;

import com.springbootmybatisstater.enums.UserSexEnum;
import com.springbootmybatisstater.mapper.UserMapper;
import com.springbootmybatisstater.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * TODO:
 *
 * @author WangLonglong
 * @email caption1215@gmail.com
 * @date 2019/3/20 15:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        userMapper.insert(new User("aa1", "a123456", UserSexEnum.MAN));
        userMapper.insert(new User("bb1", "b123456", UserSexEnum.WOMAN));
        userMapper.insert(new User("cc1", "b123456", UserSexEnum.WOMAN));

        Assert.assertEquals(3, userMapper.getAll().size());
    }
}
