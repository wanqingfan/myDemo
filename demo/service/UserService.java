package com.demo.service;

import com.demo.model.management.User;
import com.jfinal.plugin.activerecord.Page;

public class UserService {
    public static final UserService userService = new UserService();

    private User dao = new User().dao();

    public Page<User> paginate(int pageNumber, int pageSize) {
        return dao.paginate(pageNumber, pageSize, "select *", "from user order by createDate asc");
    }
}
