package com.steamnonesteam.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.j256.ormlite.dao.Dao;
import com.steamnonesteam.json.serializers.UserGameSerializer;
import com.steamnonesteam.model.UserGame;

import java.sql.SQLException;
import java.util.ArrayList;

public class LibraryService {
    private Dao<UserGame,Integer> libraryDao;
    public LibraryService(Dao<UserGame,Integer> userGameDao){
        this.libraryDao=userGameDao;
    }
    public String findLibraryByUser(int id) throws SQLException, JsonProcessingException {
        ArrayList<UserGame> library= (ArrayList<UserGame>) libraryDao.queryForEq("userId",id);
        ObjectMapper om=new ObjectMapper();
        SimpleModule m=new SimpleModule();
        m.addSerializer(UserGame.class,new UserGameSerializer());
        om.registerModule(m);
        return om.writeValueAsString(library);
    }
//    public String saveLibrary(int gameId){
//
//    }

    public void deleteLibraryByUserIdGameId(int userId,int gameId) throws SQLException {
        ArrayList<UserGame> library= (ArrayList<UserGame>) libraryDao.queryForEq("gameId",gameId);
        ObjectMapper om=new ObjectMapper();
        SimpleModule m=new SimpleModule();
        m.addSerializer(UserGame.class,new UserGameSerializer());
        om.registerModule(m);
        for(int i=0;i<library.size();i++){
            if(library.get(i).getUserId().getId()==userId){
                libraryDao.deleteById(library.get(i).getId());
            }
        }
    }



}
