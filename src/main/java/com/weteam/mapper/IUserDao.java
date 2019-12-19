package com.weteam.mapper;

import com.weteam.model.domain.User;

public interface IUserDao {

    User findUserById(int id);
}
