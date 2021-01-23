package com.steamnonesteam.service;

import com.j256.ormlite.dao.Dao;
import com.steamnonesteam.model.User;

public class UserService extends AbstractService<User>{
    public UserService(Dao<User, Integer> dao) {
        super(dao);
    }
}
