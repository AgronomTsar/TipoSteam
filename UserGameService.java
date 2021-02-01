package com.steamnonesteam.service;

import com.j256.ormlite.dao.Dao;
import com.steamnonesteam.model.UserGame;

public class UserGameService extends AbstractService<UserGame>{
    public UserGameService(Dao<UserGame, Integer> dao) {
        super(dao);
    }

}
