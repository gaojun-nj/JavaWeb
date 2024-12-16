package top.soft.bookonline.service.impl;


import top.soft.bookonline.dao.UserDao;
import top.soft.bookonline.dao.impl.UserDaolmpl;
import top.soft.bookonline.entity.Book;
import top.soft.bookonline.entity.User;
import top.soft.bookonline.service.UserService;

import java.util.List;

/**
 * @author Administrator
 * @description: TODO
 * @date 2024/10/26 14:12
 */
public class UserServicelmpl implements UserService {
    private final UserDao userDao = new UserDaolmpl();



    @Override
    public User signIn(String account, String password) {
        User user = User.builder().account(account).password(password).build();
        return userDao.findUser(user);

    }
}