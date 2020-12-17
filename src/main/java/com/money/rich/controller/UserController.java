package com.money.rich.controller;

import com.money.rich.mapper.UserMapper;
import com.money.rich.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping
    public List<UserVO> userList(){
        System.out.println(userMapper.userList());
        System.out.println("유저리스트 출력 성공");
        return userMapper.userList();
    }

    @PostMapping
    public void insertUser(@RequestBody UserVO vo) {
        userMapper.insertUser(vo);
        System.out.println("유저 DB 저장 성공");
    }

    @GetMapping("/{id}")
    public UserVO fetchUserByID(@PathVariable int id) {
        System.out.println(userMapper.fetchUserByID(id));
        UserVO vo = userMapper.fetchUserByID(id);
        return vo;
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody UserVO user) {
        UserVO updateUser = user;
        System.out.println("업데이트 유저 ==> " + user);

        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setAge(user.getAge());
        updateUser.setSalary(user.getSalary());

        userMapper.updateUser(updateUser);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userMapper.deleteUser(id);
        System.out.println(id + "DB 삭제");
    }

}
