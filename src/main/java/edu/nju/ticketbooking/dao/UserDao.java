package edu.nju.ticketbooking.dao;

import edu.nju.ticketbooking.model.User;

import java.util.List;

public interface UserDao {

    User getUser(int userId);

    User getUserByEmail(String email);

    /**
     * 修改用户信息
     *
     * @param modifiedUser 修改后的用户信息
     * @return 修改后的用户信息，若修改失败则为null
     */
    User modifyUser(User modifiedUser);

    /**
     * 申请新用户
     */
    User addNewUser(User newUser);

    List<User> getUserList(String condition, Object value);

}
