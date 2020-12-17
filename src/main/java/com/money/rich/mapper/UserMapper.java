package com.money.rich.mapper;

import com.money.rich.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserVO> userList();
    UserVO fetchUserByID(int id);
    void updateUser(UserVO user);
    void insertUser(UserVO user);
    void deleteUser(int id);

}
