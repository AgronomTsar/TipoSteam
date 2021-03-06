package com.steamnonesteam.service;

import com.j256.ormlite.dao.Dao;
import com.steamnonesteam.model.Game;

public class GameService extends AbstractService<Game>{
    public GameService(Dao<Game, Integer> dao) {
        super(dao);

    }
}
